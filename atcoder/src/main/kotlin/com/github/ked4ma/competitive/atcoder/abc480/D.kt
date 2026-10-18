package com.github.ked4ma.competitive.atcoder.abc480

import com.github.ked4ma.competitive.common.array.long.bound.*
import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val A = nextLongList()
    val cum = sizedLongArray(N + 1)
    val cnt = sizedLongArray(N + 1)
    val cum2 = sizedLongArray(N + 1)
    for (i in 0 until N) {
        cum[i + 1] = cum[i] + A[i]
        cnt[i + 1] = cnt[i] + i + 1
        cum2[i + 1] = cum2[i] + cum[i + 1]
    }
    _debug_println(cum)
    _debug_println(cnt)
    _debug_println(cum2)
    repeat(Q) {
        var (L, R) = nextLongList()
        L--
        val li = cnt.upperBound(L) - 1
        val ri = cnt.upperBound(R) - 1
        _debug_println("($L, $R) => ($li, $ri)")
        val l = cum2[li] + cum[(L - cnt[li]).toInt()]
        val r = cum2[ri] + cum[(R - cnt[ri]).toInt()]
        println(r - l)
//        _debug_println(l)
    }
}
