package com.github.ked4ma.competitive.atcoder.abc430

import com.github.ked4ma.competitive.common.array.int.bound.*
import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, A, B) = nextIntList()
    val S = nextCharArray()
    val aCnt = sizedIntArray(N + 1, 0)
    val bCnt = sizedIntArray(N + 1, 0)
    for (i in 0 until N) {
        aCnt[i + 1] += aCnt[i]
        bCnt[i + 1] += bCnt[i]
        when (S[i]) {
            'a' -> aCnt[i + 1] += 1
            'b' -> bCnt[i + 1] += 1
        }
    }
    _debug_println(aCnt)
    _debug_println(bCnt)
    var ans = 0L
    for (l in 0 until N) {
        val rMinA = aCnt.lowerBound(A + aCnt[l])
        val rMinB = bCnt.lowerBound(B + bCnt[l])
        _debug_println(rMinA)
        _debug_println(rMinB)
        if (rMinA < rMinB) {
            ans += rMinB - rMinA
        }
    }
    println(ans)
}
