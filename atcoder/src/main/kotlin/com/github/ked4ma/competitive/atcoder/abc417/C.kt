package com.github.ked4ma.competitive.atcoder.abc417

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList()

    var ans = 0L
    val map = mutableMapOf(0 + A[0] to 1)
    for (i in 1 until N) {
        map[i - A[i]]?.let {
            ans += it
        }
        map[i + A[i]] = map.getOrDefault(i + A[i], 0) + 1
    }
    println(ans)
}
