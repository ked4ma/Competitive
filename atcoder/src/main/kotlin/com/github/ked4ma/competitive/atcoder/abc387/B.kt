package com.github.ked4ma.competitive.atcoder.abc387

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val X = nextInt()
    val nums = buildList {
        for (i in 1..9) {
            for (j in 1..9) {
                add(i * j)
            }
        }
    }
    println(nums.filter { it != X }.sum())
}
