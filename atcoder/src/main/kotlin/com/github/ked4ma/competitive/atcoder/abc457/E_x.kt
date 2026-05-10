package com.github.ked4ma.competitive.atcoder.abc457

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.boolean.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.int.bound.*
import com.github.ked4ma.competitive.common.number.inf.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val LR = times(M) {
        val (L, R) = nextIntList()
        L to R
    }
    val dict = LR.groupingBy { it }.eachCount()
    val byL = sizedArray(N + 1) { mutableListOf<Int>() }
    val byR = sizedArray(N + 1) { mutableListOf<Int>() }
    val minRatL = sizedIntArray(N + 2, INT_INF)
    for ((l, r) in LR) {
        byL[l].add(r)
        byR[r].add(l)
        minRatL[l] = min(minRatL[l], r)
    }
    for (i in 1..N) {
        byL[i].sort()
        byR[i].sort()
    }
    for (i in (0..N).reversed()) {
        minRatL[i] = min(minRatL[i], minRatL[i + 1])
    }

    _debug_println(minRatL)
    val Q = nextInt()
    repeat(Q) {
        val (s, t) = nextIntList()
        if ((s to t) in dict) {
            var ok = false
            ok = ok or (dict.getValue(s to t) >= 2)
            ok = ok or (minRatL[s + 1] <= t)
            ok = ok or (minRatL[s] <= t - 1)
            println(ok.toYesNo())
            return@repeat
        }

        var ok = false
        val rs = byL[s]
        val r = rs.upperBound(t) - 1
        val ls = byR[t]
        val l = ls.lowerBound(s)
        if (r >= 0 && l < ls.size) {
            val r1 = rs[r]
            val l2 = ls[l]
            ok = l2 <= r1 + 1
        }
        println(ok.toYesNo())
    }
}
