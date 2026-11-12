package com.github.ked4ma.competitive.atcoder.awc0199

import com.github.ked4ma.competitive.common.array.int.d2.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.cumlative.d2sum.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.max

fun main() {
    val (N, W, H) = nextIntList()
    val (X, Y) = times(N) {
        val (X, Y) = nextIntList()
        X to Y
    }.unzip()
    val x = X.sorted().distinct()
    val y = Y.sorted().distinct()
    val xMap = x.withIndex().associate { it.value to it.index }
    val yMap = y.withIndex().associate { it.value to it.index }
    _debug_println(xMap)
    _debug_println(yMap)

    val cnt = sized2DIntArray(y.size, x.size)
    for (i in 0 until N) {
        cnt[yMap.getValue(Y[i])][xMap.getValue(X[i])]++
    }
    _debug_println(cnt)
    val cum = CumulativeSum2D(cnt)

    var ans = 0L
    var r = 0
    for (l in 0 until xMap.size) {
        while (r < x.size && x[r] - x[l] <= W) r++
        var d = 0
        for (u in 0 until yMap.size) {
            while (d < y.size && y[d] - y[u] <= H) d++
            _debug_println("$l $u $r $d : ${cum.sumOf(l, u, r, d)}")
            ans = max(ans, cum.sumOf(l, u, r, d))
        }
    }
    _debug_println(N == 20) { cum.sumOf(9, 5, 10, 6) }
    _debug_println(N == 20) { cum.sumOf(15, 10, 16, 11) }
    _debug_println(N == 20) { cum.data }
    println(ans)
}
