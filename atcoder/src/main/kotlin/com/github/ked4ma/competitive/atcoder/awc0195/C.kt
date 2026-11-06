package com.github.ked4ma.competitive.atcoder.awc0195

import com.github.ked4ma.competitive.common.array.char.d2.*
import com.github.ked4ma.competitive.common.array.int.d2.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W) = nextIntList()
    val S = times(H) { nextCharArray() }

    val arr = sized2DIntArray(H + 2, W + 2)
    for (h in 0 until H) {
        for (w in 0 until W) {
            if (S[h][w] == '1') arr[h + 1][w + 1]++
        }
    }

    val Q = nextInt()
    repeat(Q) {
        val (R, C) = nextIntList()
        arr[R][C]++
        arr[R - 1][C]++
        arr[R + 1][C]++
        arr[R][C - 1]++
        arr[R][C + 1]++
    }

    val ans = sized2DCharArray(H, W, '0')
    for (h in 1..H) {
        for (w in 1..W) {
            ans[h - 1][w - 1] = if (arr[h][w] % 2 == 0) '0' else '1'
        }
    }
    println(ans.joinToString("\n") { it.concatToString() })
}
