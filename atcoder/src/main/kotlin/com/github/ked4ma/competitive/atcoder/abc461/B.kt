package com.github.ked4ma.competitive.atcoder.abc461

import com.github.ked4ma.competitive.common.boolean.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList().map { it - 1 }
    val B = nextIntList().map { it - 1 }
    var ans = true
    for (i in 0 until N) {
        if (B[A[i]] != i) {
            ans = false
            break
        }
    }
    println(ans.toYesNo())
}
