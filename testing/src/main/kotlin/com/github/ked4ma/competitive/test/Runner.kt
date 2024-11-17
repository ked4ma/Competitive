package com.github.ked4ma.competitive.test

import com.github.ked4ma.competitive.test.client.TaskClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.PipedInputStream
import java.io.PipedOutputStream
import java.lang.reflect.Method

class Runner {
    private val client: TaskClient
    private val method: Method
    private val contestDir: String
    private val task: String

    constructor(
        platform: Platform,
        basePackage: String,
        contestDir: String,
        task: String
    ) {
        client = TaskClient.instanceOf(platform)
        method = Class.forName("$basePackage.$contestDir.${task}Kt").getMethod("main")
            ?: throw RuntimeException("target method is not found ($contestDir/$task)")
        this.contestDir = contestDir
        this.task = task
    }

    constructor(
        platform: Platform,
        contestDir: String,
        task: String,
        method: Method?
    ) {
        client = TaskClient.instanceOf(platform)
        this.method = method ?: throw RuntimeException("target method is not found ($contestDir/$task)")
        this.contestDir = contestDir
        this.task = task
    }

    suspend fun setup() {
        if (!contestDir.endsWith("_na") && client.sessionCookie() == null) {
            withContext(Dispatchers.IO) {
                val user = System.getenv("USER")
                val password = System.getenv("PASSWORD")
                client.login(user, password)
            }
        }
    }

    suspend fun exec(input: String, expected: String): String {
        val originalInputStream = System.`in`
        val originalOutputStream = System.out
        println("----- input ------")
        println(input)
        println("----- actual -----")
        val inputStream = PipedInputStream()
        val outputStream = withContext(Dispatchers.IO) {
            PipedOutputStream(inputStream)
        }
        val resultStream = PrintCaptureStream()
        System.setIn(inputStream)
        System.setOut(resultStream)
        // exec main fun
        execExample(input, outputStream)
        // get captured output
        val actual = withContext(Dispatchers.IO) {
            resultStream.read()
        }
        System.setIn(originalInputStream)
        System.setOut(originalOutputStream)
        println(actual)
        println("---- expected ----")
        println(expected)
        return actual
    }

    private suspend fun execExample(
        input: String,
        outputStream: PipedOutputStream
    ) = coroutineScope {
        listOf(
            launch {
                method.invoke(null)
            },
            launch(Dispatchers.IO) {
                outputStream.write("$input\n".toByteArray())
                outputStream.flush()
            }
        ).joinAll()
    }

    suspend fun retrieveExamples(): List<Pair<String, String>> {
        val url = client.getTaskUrl(
            contestDir.split("_")[0],
            task.split("_")[0]
        )
        return client.retrieveExamples(url)
    }
}