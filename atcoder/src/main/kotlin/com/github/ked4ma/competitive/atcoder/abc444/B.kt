package com.github.ked4ma.competitive.atcoder.abc444

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextIntList()
    var ans = 0
    for (i in 1..N) {
        val s = i.toString()
        if (s.sumOf { it - '0' } == K) ans ++
    }
    println(ans)
}
