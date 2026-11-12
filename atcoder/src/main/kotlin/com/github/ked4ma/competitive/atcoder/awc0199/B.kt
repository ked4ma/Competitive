package com.github.ked4ma.competitive.atcoder.awc0199

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.div.ceil.*

fun main() {
    val (N, K) = nextIntList()
    val S = nextCharArray() + '#'
    var k = 0
    var ans = 0
    for (i in 0 until N + 1) {
        if (S[i] == '#') {
            if (k == 0) continue
            if (k / K == 0) {
                println(-1)
                return
            }
            ans += k.ceilDiv(K)
            k = 0
        } else {
            k++
        }
    }
    println(ans)
}
