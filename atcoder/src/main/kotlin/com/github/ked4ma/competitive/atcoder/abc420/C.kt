package com.github.ked4ma.competitive.atcoder.abc420

import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val A = nextLongList().toLongArray()
    val B = nextLongList().toLongArray()
    var ans = 0L
    for (i in 0 until N) {
        ans += min(A[i], B[i])
    }

    repeat(Q) {
        val (c, X, V) = nextList().let { (c, X, V) -> Triple(c, X.toInt() - 1, V.toLong()) }
        ans -= min(A[X], B[X])
        if (c == "A") {
            A[X] = V
        } else {
            B[X] = V
        }
        ans += min(A[X], B[X])
        println(ans)
    }
}
