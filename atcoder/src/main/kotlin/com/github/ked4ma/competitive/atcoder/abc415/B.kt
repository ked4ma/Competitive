package com.github.ked4ma.competitive.atcoder.abc415

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = next()
    val list = buildList {
        S.forEachIndexed { i, c ->
            if (c == '#') add(i + 1)
        }
    }
    list.windowed(2, 2).forEach {
        println(it.joinToString(","))
    }
}
