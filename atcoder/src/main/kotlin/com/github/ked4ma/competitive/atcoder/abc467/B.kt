package com.github.ked4ma.competitive.atcoder.abc467

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    var X = 10000
    var Y = 10000
    repeat(N) {
        val (A, B, S) = nextList().let { (A, B, S) -> Triple(A.toInt(), B.toInt(), S) }
        if (S == "keep") {
            X -= B
        } else {
            X -= A
        }
        Y -= A
    }
    println(Y - X)
}
