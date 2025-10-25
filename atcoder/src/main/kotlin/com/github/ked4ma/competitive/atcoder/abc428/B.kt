package com.github.ked4ma.competitive.atcoder.abc428

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextIntList()
    val S = next()
    val count = S.windowed(K, 1).groupingBy { it }.eachCount()
    val max = count.values.max()
    buildSet {
        for ((k, v) in count) {
            if (v == max) add(k)
        }
    }.sorted().let {
        println(max)
        println(it.joinToString(" "))
    }
}
