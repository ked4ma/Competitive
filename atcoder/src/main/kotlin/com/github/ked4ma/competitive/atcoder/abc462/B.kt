package com.github.ked4ma.competitive.atcoder.abc462

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.int.output.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val ans = sizedArray(N) { mutableListOf<Int>() }
    repeat(N) { i ->
        val data = nextIntList()
        for (j in 1 until data.size) {
            val a = data[j] - 1
            ans[a].add(i + 1)
        }
    }
    for (l in ans) {
        (listOf(l.size) + l).println(" ")
    }
}
