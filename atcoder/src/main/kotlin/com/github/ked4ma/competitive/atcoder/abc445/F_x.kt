package com.github.ked4ma.competitive.atcoder.abc445

import com.github.ked4ma.competitive.common.array.long.d2.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import com.github.ked4ma.competitive.common.number.int.bit.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.min

typealias G = Array<LongArray>

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextIntList()
    val C: G = times(N) { nextLongList().toLongArray() }.toTypedArray()

    fun mul(a: G, b: G): G {
        val g = sized2DLongArray(N, N, LONG_INF)
        for (i in 0 until N) {
            for (j in 0 until N) {
                for (k in 0 until N) {
                    g[i][j] = min(g[i][j], a[i][k] + b[k][j])
                }
            }
        }
        return g
    }

    var g = sized2DLongArray(N, N, LONG_INF)
    for (i in 0 until N) g[i][i] = 0
    var c = C
    var k = K
    while (k > 0) {
        if (k.bit(0)) {
            g = mul(g, c)
        }
        c = mul(c, c)
        k /= 2
    }
    for (i in 0 until N) {
        println(g[i][i])
    }
}
