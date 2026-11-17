package com.github.ked4ma.competitive.atcoder.awc0202

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.int.bound.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.max

fun main() {
    val (H, W) = nextIntList()
    val S = times(H) { nextCharArray() }

    val hArr = sizedArray(H) { mutableListOf(-1) }
    val wArr = sizedArray(W) { mutableListOf(-1) }
    for (h in 0 until H) {
        for (w in 0 until W) {
            if (S[h][w] == '#') {
                hArr[h].add(w)
                wArr[w].add(h)
            }
        }
    }
    for (h in 0 until H) hArr[h].add(W)
    for (w in 0 until W) wArr[w].add(H)

    var ans = -1
    for (h in 0 until H) {
        for (w in 0 until W) {
            if (S[h][w] == '#') continue
            val i = hArr[h].upperBound(w)
            val j = wArr[w].upperBound(h)
            ans = max(ans, hArr[h][i] - hArr[h][i - 1] - 1 + wArr[w][j] - wArr[w][j - 1] - 1 - 1)
        }
    }
    println(ans)
}
