package com.github.ked4ma.competitive.atcoder.abc384

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, R) = nextIntList()
    var ans = R
    repeat(N) {
        val (D, A) = nextIntList()
        when {
            D == 1 && ans in 1600..2799 -> {
                ans += A
            }

            D == 2 && ans in 1200..2399 -> {
                ans += A
            }
        }
    }
    println(ans)
}
