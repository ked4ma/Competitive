package com.github.ked4ma.competitive.atcoder.abc477

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.boolean.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val Q = nextInt()
    val S = next()
    val T = next()

    val l = sizedIntArray(S.length + 1)
    val r = sizedIntArray(S.length + 1)
    for (i in 0 until S.length) {
        l[i + 1] += l[i]
        r[i + 1] += r[i]
        var j = 0
        while (i + j < S.length && j < T.length && S[i + j] == T[j]) j++
        if (j == T.length) {
            l[i + 1]++
            r[i + T.length]++
        }
    }
    repeat(Q) {
        val (L, R) = nextIntList()
//        val ll = l.upperBound(l[L - 1])
//        val rr = r.upperBound(r[R]) - 1
//        _debug_println("$ll $rr")
        println((r[R] - l[L - 1] > 0).toYesNo())
    }
}
