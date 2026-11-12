package com.github.ked4ma.competitive.atcoder.awc0198

import com.github.ked4ma.competitive.common.debug._debug_println
import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.min

fun main() {
    val (N, K, X) = nextLongList().let { (N, K, X) -> Triple(N.toInt(), K.toInt(), X) }
    val A = nextLongList()
    var r = 0
    var s = 0L
    var ans = 0L
    for (i in 0 until N) {
        while (r < N && s < X) {
            s += A[r]
            r++
        }
        _debug_println("$i $r $s")
        if (s >= X && r - i <= K) {
            _debug_println("$i $r")
            ans += min(N, i + K) - r + 1
        }
        s -= A[i]
    }
    println(ans)
}
