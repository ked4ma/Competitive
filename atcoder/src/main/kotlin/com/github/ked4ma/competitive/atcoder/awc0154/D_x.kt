package com.github.ked4ma.competitive.atcoder.awc0154

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.array.int.d2.*
import com.github.ked4ma.competitive.common.array.int.d2.chmin.*
import com.github.ked4ma.competitive.common.array.int.output.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*

fun main() {
    val (N, M) = nextIntList()
    val G = sizedArray(N) { mutableListOf<Pair<Int, Int>>() }
    val dist = sized2DIntArray(N, N, INT_INF)
    for (i in 0 until N) {
        dist[i][i] = 0
    }
    repeat(M) {
        val (u, v, w) = nextIntList()
        G[u - 1].add(v - 1 to w)
        dist[u - 1][v - 1] = w
    }
    for (k in 0 until N) {
        for (i in 0 until N) {
            for (j in 0 until N) {
                dist.chmin(i, j, dist[i][k] + dist[k][j])
            }
        }
    }
    _debug_println(dist)

    val ans = sizedIntArray(N)
    for (k in 0 until N) {
        for (i in 0 until N) {
            for (j in 0 until N) {
                if (i == k || j == k) continue
                if (dist[i][j] == dist[i][k] + dist[k][j]) {
                    ans[k]++
                }
            }
        }
    }
    ans.println("\n")
}
