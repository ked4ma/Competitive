package com.github.ked4ma.competitive.atcoder.awc0194

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

fun main() {
    val (H, W) = nextIntList()
    val S = times(H) { nextCharArray() }

    var ans = 0
    var m = -1
    for (w in 0 until W) {
        var c = 0
        for (h in 0 until H) {
            if (S[h][w] == 'F') c++
        }
        if (c > m) {
            m = c
            ans = w + 1
        }
    }
    println(ans)
}
