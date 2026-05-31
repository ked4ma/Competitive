package com.github.ked4ma.competitive.atcoder.abc460

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val A = nextIntList().sortedDescending()
    val B = nextIntList().sortedDescending()
    var i = 0
    var ans = 0
    for (a in A) {
        while (i < M && 2 * a < B[i]) i++
        if (i < M) {
            ans++
            i++
        }
    }
    println(ans)
}
