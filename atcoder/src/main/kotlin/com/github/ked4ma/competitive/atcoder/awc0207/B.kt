package com.github.ked4ma.competitive.atcoder.awc0207

import com.github.ked4ma.competitive.common.input.default.*

fun main() {
    val (H, W) = nextIntList()
    repeat(H) {
        val S = nextCharArray()
        for (i in 0 until W) {
            if (S[i] == 'o') {
                println(i + 1)
                return@repeat
            }
        }
        println(-1)
    }
}
