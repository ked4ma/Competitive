package com.github.ked4ma.competitive.atcoder.awc0194

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.long.d2.*
import com.github.ked4ma.competitive.common.debug._debug_println
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.component.*
import com.github.ked4ma.competitive.common.number.inf.*
import java.util.*

fun main() {
    data class D(val u: Int, val v: Int, val a: Int, val b: Int, val s: Long, val t: Long)
    var (N, M, K) = nextIntList()
    K /= 2
    val G = sizedArray(N) { mutableListOf<Pair<Int, D>>() }
    repeat(M) {
        var (u, v, a, b, s, t) = nextIntList()
        u--
        v--
        val d = D(u, v, a, b, s.toLong(), t.toLong())
        G[u].add(v to d)
        G[v].add(u to d)
    }

    val dp = sized2DLongArray(N, K + 1, LONG_INF)
    val q = PriorityQueue<Triple<Int, Int, Long>>(compareBy { it.third })
    q.offer(Triple(0, 0, 0L))
    while (q.isNotEmpty()) {
        val (u, k, c) = q.poll()
        _debug_println("$u:: $c")
        if (dp[u][k] <= c) continue
        dp[u][k] = c
        for ((v, d) in G[u]) {
            if (k + d.a <= K) {
                val nk = k + d.a
                if (dp[v][nk] > c + d.s) {
                    q.offer(Triple(v, nk, c + d.s))
                }
            }
            if (k + d.b <= K) {
                val nk = k + d.b
                if (dp[v][nk] > c + d.t) {
                    q.offer(Triple(v, nk, c + d.t))
                }
            }
        }
    }
    var ans = dp.last().min()
    if (ans == LONG_INF) ans = -1
    println(ans)
    _debug_println(N == 2) { dp }
}
