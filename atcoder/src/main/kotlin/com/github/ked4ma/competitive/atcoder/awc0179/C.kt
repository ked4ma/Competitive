package com.github.ked4ma.competitive.atcoder.awc0179

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*

fun main() {
    val (N, K) = nextIntList()
    val cat = sizedIntArray(N)
    var ans = 0L
    repeat(N) {
        var (b, d) = nextIntList()
        b--
        if (d > cat[b]) {
            ans += d - cat[b]
            cat[b] = d
        }
    }
    println(ans)
}
