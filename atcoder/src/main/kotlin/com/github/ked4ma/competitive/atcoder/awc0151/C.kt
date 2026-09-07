package com.github.ked4ma.competitive.atcoder.awc0151

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.debug._debug_println
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val AT = times(N) {
        val (A, T) = nextLongList()
        A to T
    }
    val arr = sizedLongArray(N + 1)
    repeat(Q) {
        val (L, R, X) = nextLongList().let { (L, R, X) -> Triple(L.toInt() - 1, R.toInt(), X) }
        arr[L] += X
        arr[R] -= X
        _debug_println(arr.joinToString(" "))
    }
    for (i in 1 until N) {
        arr[i] += arr[i - 1]
    }
    _debug_println(arr.joinToString(" "))
    var ans = 0
    for (i in 0 until N) {
        val (a, t) = AT[i]
        if (a + arr[i] >= t) ans++
    }
    println(ans)
}
