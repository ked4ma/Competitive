package com.github.ked4ma.competitive.atcoder.abc430

import com.github.ked4ma.competitive.common.acl.zalgorithm.string.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    val A = next()
    val B = next()
    val N = A.length
    val arr = (B + A + A).zAlgorithm()
    for (i in N until 2 * N) {
        if (arr[i] >= N) {
            println(i - N)
            return
        }
    }
    println(-1)
}


