package com.github.ked4ma.competitive.atcoder.awc0173

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*

fun main() {
    val (H, W) = nextIntList()
    val cnt = sizedIntArray(W)
    var ans = W
    repeat(H) {
        val S = next()
        for (w in 0 until W) {
            if (S[w] == '#') {
                if (cnt[w] == 0) ans--
                cnt[w]++
            }
        }
    }
    println(ans)
}
