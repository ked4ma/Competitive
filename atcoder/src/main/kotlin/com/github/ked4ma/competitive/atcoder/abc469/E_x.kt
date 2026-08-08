package com.github.ked4ma.competitive.atcoder.abc469

import com.github.ked4ma.competitive.common.array.double.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextIntList()
    val S = nextCharArray()

    fun judge(x: Double): Boolean {
        val a = sizedDoubleArray(N + 1)
        for (i in 0 until N) {
            var w = -x
            if (S[i] == 'o') w++
            a[i + 1] = a[i] + w
        }

        var p = 0
        var o = 0
        var minA = Double.MAX_VALUE / 2
        for (r in 0 until N) {
            if (S[r] == 'o') o++
            while (o >= K) {
                minA = min(minA, a[p])
                if (S[p] == 'o') o--
                p++
            }
            if (a[r + 1] - minA >= 0) return true
        }
        return false
    }

    var ok = 0.0
    var ng = 1.0
    repeat(30) {
        val m = (ok + ng) / 2
        if (judge(m)) {
            ok = m
        } else {
            ng = m
        }
    }
    println("%.10f".format(ok))
}
