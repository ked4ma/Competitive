package com.github.ked4ma.competitive.atcoder.awc0192

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    var ans = 0
    var m = 0
    repeat(N) {
        val (A, B) = nextIntList()
        if (m < A * B) {
            ans = it + 1
            m = A * B
        }
    }
    println(ans)
}
