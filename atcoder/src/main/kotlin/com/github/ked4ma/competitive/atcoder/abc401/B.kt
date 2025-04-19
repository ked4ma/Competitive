package com.github.ked4ma.competitive.atcoder.abc401

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    var ans = 0
    var state = 0
    repeat(N) {
        when (next()) {
            "login" -> state = 1
            "logout" -> state = 0
            "public" -> Unit
            "private" -> {
                if (state == 0) ans++
            }
        }
    }
    println(ans)
}
