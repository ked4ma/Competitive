package com.github.ked4ma.competitive.atcoder.abc431

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    var sumW = 0
    var sumH = 0L
    var sumB = 0L
    val P = times(N) {
        val (W, H, B) = nextLongList()
        sumW += W.toInt()
        sumH += H
        sumB += B
        Triple(W.toInt(), H, B)
    }
    _debug_println("$sumW, $sumH $sumB")
    val hW = sumW / 2
    val dp = sizedLongArray(hW + 1, 0L)
    dp[0] = sumB
    for (i in 0 until N) {
        val (w, h, b) = P[i]
        for (j in (0 until hW).reversed()) {
            if (dp[j] == 0L) continue
            val nw = j + w
            if (nw > hW) continue
            dp[nw] = max(dp[nw], dp[j] + h - b)
        }
        _debug_println(N == 3) { dp }
    }
    _debug_println(N == 3) { dp }
    println(dp.max())
}
