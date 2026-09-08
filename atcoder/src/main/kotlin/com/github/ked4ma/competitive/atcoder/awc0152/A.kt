package com.github.ked4ma.competitive.atcoder.awc0152

import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.max
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M, S, T) = nextIntList()
    val s = min(S, T)
    val t = max(S, T)
    var ans = 0L
    repeat(M) {
        val (P, V) = nextIntList()
        if (P in s..t) {
            ans += V
        }
    }
    println(ans)
}
