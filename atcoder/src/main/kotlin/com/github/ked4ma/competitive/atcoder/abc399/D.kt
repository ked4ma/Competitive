package com.github.ked4ma.competitive.atcoder.abc399

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.max
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

fun solve() {
    val N = nextInt()
    val A = nextIntList()
    val ng = mutableSetOf<Int>()
    for (i in range(2 * N - 1)) {
        if (A[i] == A[i + 1]) ng.add(A[i])
    }
    val map = mutableMapOf<Pair<Int, Int>, Int>()
    var ans = 0
    for (i in range(2 * N - 1)) {
        val a = A[i]
        val b = A[i + 1]
        if (a in ng || b in ng) continue
        val key = min(a, b) to max(a, b)
        if (key in map) {
            if (i > map.getValue(key) + 1) {
                ans++
            }
        } else {
            map[key] = i
        }
    }
    println(ans)
}
