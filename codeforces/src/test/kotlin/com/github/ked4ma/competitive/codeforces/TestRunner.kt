package com.github.ked4ma.competitive.codeforces

import com.github.ked4ma.competitive.test.Platform
import com.github.ked4ma.competitive.test.Runner
import com.github.ked4ma.competitive.test.runShell
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

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

    companion object {
        private lateinit var RUNNER: Runner

        @Suppress("unused")
        @BeforeAll
        @JvmStatic
        fun setup() {
            val task = System.getProperty("task")?.takeIf(String::isNotBlank) ?: "A"
            val branch = System.getProperty("branch")?.takeIf(String::isNotBlank)
                ?: runShell("git", "branch", "--show-current")
            val contestRegex = "contest/(.+)".toRegex()
            val contestDir = contestRegex.matchEntire(branch)?.groupValues?.get(1)
                ?: throw RuntimeException("$branch is not a valid name")
            println("$branch, $task")
            println(contestDir)
            RUNNER = Runner(
                platform = Platform.ATCODER,
                basePackage = "com.github.ked4ma.competitive.codeforces",
                contestDir = contestDir,
                task = task
            )
            runBlocking {
                RUNNER.setup()
            }
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