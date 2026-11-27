package com.github.ked4ma.competitive.atcoder.awc0210

import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val S = nextCharArray()

    var ans = 0
    for (c in S) {
        when (c) {
            'W' -> {
                ans += 3
            }

            else -> {
                ans = max(0, ans - 1)
            }
        }
    }
    println(ans)
}
