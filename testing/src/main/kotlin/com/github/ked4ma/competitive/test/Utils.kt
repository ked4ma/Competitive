package com.github.ked4ma.competitive.test

import java.io.BufferedReader
import java.io.InputStreamReader

@Suppress("SameParameterValue")
fun runShell(vararg command: String): String {
    val process = Runtime.getRuntime().exec(command)
    val reader = BufferedReader(InputStreamReader(process.inputStream))
    val text = reader.readLine();

    process.waitFor()

    return text
}
