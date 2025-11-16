package com.github.ked4ma.competitive.atcoder.abc432

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, X, Y) = nextLongList().let { (N, X, Y) -> Triple(N.toInt(), X, Y) }
    val A = nextLongList().sorted()
    var upperY1 = A[0]
    val diff = sizedLongArray(N, 0)
    for (i in 0 until N) {
        val a = A[i]
        if ((X * (a - A[0])) % (Y - X) != 0L) {
            println(-1)
            return
        }
        diff[i] = (X * (a - A[0])) / (Y - X)
        if (diff[i] > A[0]) {
            println(-1)
            return
        }
    }
    _debug_println("$upperY1 >= y1")
    _debug_println(diff)
    if (upperY1 < 0) {
        println(-1)
        return
    }
    var ans = 0L
    for (i in 0 until N) {
        ans += A[0] - diff[i]
    }
    println(ans)
}
