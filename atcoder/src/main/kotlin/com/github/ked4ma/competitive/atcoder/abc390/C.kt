package com.github.ked4ma.competitive.atcoder.abc390

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.cumlative.d2sum.*
import com.github.ked4ma.competitive.common.repeat.*
import com.github.ked4ma.competitive.common.repeat.range.*
import kotlin.math.max
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W) = nextIntList()
    val S = times(H) { nextCharArray() }

    val whiteCum = CumulativeSum2D(S.map { row -> row.map { if (it == '.') 1L else 0L } })
    var l = Int.MAX_VALUE
    var r = Int.MIN_VALUE
    var t = Int.MAX_VALUE
    var b = Int.MIN_VALUE
    for (h in range(H)) {
        for (w in range(W)) {
            if (S[h][w] == '#') {
                l = min(l, w)
                r = max(r, w)
                t = min(t, h)
                b = max(b, h)
            }
        }
    }
    println(if (whiteCum.getSumOf(l, t, r, b) == 0L) "Yes" else "No")
}
