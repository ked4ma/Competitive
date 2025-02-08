package com.github.ked4ma.competitive.atcoder.abc391

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = nextCharArray()
    S.map { c ->
        when (c) {
            'N' -> 'S'
            'S' -> 'N'
            'E' -> 'W'
            'W' -> 'E'
            else -> throw RuntimeException()
        }
    }.joinToString("").let {
        println(it)
    }
}
