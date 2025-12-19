package com.github.ked4ma.competitive.atcoder.abc436

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val rows = mutableMapOf<Int, MutableSet<Int>>()
    var cnt = 0
    repeat(M) {
        val (R, C) = nextIntList()
        if (!((rows[R]?.let { it.contains(C) || it.contains(C + 1) } ?: false)
                    || (rows[R + 1]?.let { it.contains(C) || it.contains(C + 1) } ?: false))) {
            rows.putIfAbsent(R, mutableSetOf())
            rows.putIfAbsent(R + 1, mutableSetOf())
            rows.getValue(R).add(C)
            rows.getValue(R).add(C + 1)
            rows.getValue(R + 1).add(C)
            rows.getValue(R + 1).add(C + 1)
            cnt++
        }
    }
    println(cnt)
}
