package com.github.ked4ma.competitive.training

import com.github.ked4ma.competitive.test.Platform
import com.github.ked4ma.competitive.test.Runner
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.io.PipedOutputStream
import java.lang.reflect.Method

class TestRunner {
    @ParameterizedTest
    @MethodSource("sampleProvider")
    fun testEachSample(input: String, expected: String) = runBlocking {
        val actual = RUNNER.exec(input, expected)
        val actualWithoutDebug = actual.split("\n")
            .filterNot { it.startsWith("[DEBUG]") }
            .joinToString(separator = "\n")
        assertEquals(expected, actualWithoutDebug)
    }

    private suspend fun execSample(
        method: Method,
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

    companion object {
        private lateinit var RUNNER: Runner

        @BeforeAll
        @JvmStatic
        fun setup() {
            val clazz = Class.forName("com.github.ked4ma.competitive.training.code.CodeKt")
            val platform = Platform.valueOf((clazz.getDeclaredField("PLATFORM").get(clazz) as String).uppercase())
            val contest = clazz.getDeclaredField("CONTEST").get(clazz) as String
            val task = clazz.getDeclaredField("TASK").get(clazz) as String
            val method = clazz.getMethod("main")

            println("$platform: $contest/$task")
            RUNNER = Runner(
                platform = Platform.ATCODER,
                contestDir = contest,
                task = task,
                method = method,
            )
        }

        @JvmStatic
        fun sampleProvider(): List<Arguments> {
            return runBlocking {
                RUNNER.retrieveExamples()
            }.map { (input, expected) ->
                Arguments.of(input, expected)
            }
//            return listOf(
//                Arguments.of(
//                    """
//                    """.trimIndent(),
//                    """
//                    """.trimIndent()
//                ),
//            )
        }
    }
}
