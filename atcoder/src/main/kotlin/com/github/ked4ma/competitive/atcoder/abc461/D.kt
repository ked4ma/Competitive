package com.github.ked4ma.competitive.atcoder.abc461

import com.github.ked4ma.competitive.common.debug._debug_println
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.cumlative.d2sum.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W, K) = nextIntList().let { (H, W, K) -> Triple(H, W, K.toLong()) }
    val S = times(H) { nextCharArray().map { it.digitToInt() } }
    val cum = CumulativeSum2D(S)

    fun CumulativeSum2D.lowerBound(u: Int, d: Int, l: Int, v: Long): Int {
        var i = 0
        var j = W - 1
        while (i <= j) {
            val m = (i + j) / 2
            if (this.getSumOf(l, u, m, d) < v) {
                i = m + 1
            } else {
                j = m - 1
            }
        }
        return i
    }

    fun CumulativeSum2D.upperBound(u: Int, d: Int, l: Int, v: Long): Int {
        var i = 0
        var j = W - 1
        while (i <= j) {
            val m = (i + j) / 2
            if (this.getSumOf(l, u, m, d) <= v) {
                i = m + 1
            } else {
                j = m - 1
            }
        }
        return i
    }

    var ans = 0L
    for (u in 0 until H) {
        for (d in u until H) {
            for (l in 0 until W) {
                val lr = max(l, cum.lowerBound(u, d, l, K))
                val ur = max(l, cum.upperBound(u, d, l, K))
                ans += (ur - lr)
                _debug_println("$u $d $l: ($lr $ur) -> $ans")
            }
        }
    }
    println(ans)
}
