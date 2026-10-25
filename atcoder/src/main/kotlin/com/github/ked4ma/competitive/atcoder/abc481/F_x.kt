package com.github.ked4ma.competitive.atcoder.abc481

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.mod.*
import com.github.ked4ma.competitive.common.models.number.mod.long.*
import com.github.ked4ma.competitive.common.number.inf.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    MOD = MOD998244353
    data class D(val x: Int, val c: Int) : Comparable<D> {
        override operator fun compareTo(other: D): Int = when {
            x < other.x -> -1
            x == other.x && c < other.c -> -1
            x == other.x && c == other.c -> 0
            else -> 1
        }
    }

    val (N, M) = nextIntList()
    val G = sizedArray(N) { mutableListOf<D>() }
    repeat(M) {
        val (A, B, C) = nextIntList()
        G[A - 1].add(D(B - 1, C))
    }
    val dist = sizedArray(N) { D(INT_INF, 0) }

    data class D2(val i: Int, val d: D)

    val ans = sizedArray(N) { 0.toModLong() }
    val q = PriorityQueue<D2>(compareBy { it.d })
    fun push(u: Int, p: Int, d: D) {
        _debug_println("${dist[u]} $d ${dist[u] <= d}")
        if (dist[u] <= d) return
        dist[u] = d
        if (p != -1) {
            ans[u] = ans[p] * 10 + d.c
        } else {
            ans[u] = d.c.toModLong()
        }
        q.offer(D2(u, d))
    }
    push(0, -1, D(-1, 0))
    val ps = mutableListOf(D(-1, -1))
    while (q.isNotEmpty()) {
        val (u, d) = q.poll()
        if (dist[u] != d) continue
        if (ps.last() != d) ps.add(d)
        for ((v, c) in G[u]) {
            push(v, u, D(ps.size, c))
        }
    }
    for (i in 1 until N) {
        println(ans[i].toLong())
    }
    _debug_println(ps)
}
// fun main() {
//     MOD = MOD998244353
//     data class D(val u: Int, val c: Int)
//     val (N, M) = nextIntList()
//     val G = sizedArray(N) { mutableListOf<D>() }
//     repeat(M) {
//         val (A, B, C) = nextIntList()
//         G[A - 1].add(D(B - 1, C))
//     }
//     data class D2(val i: BigInteger, val d: D)
//
//     val q = PriorityQueue<D2>(compareBy({ it.i }, { it.d.c }))
//     q.offer(D2(0.toBigInteger(), D(0, 0)))
//     val dist = sizedArray(N) { (-1).toBigInteger() }
//     while (q.isNotEmpty()) {
//         val (i, d) = q.poll()
//         if (dist[d.u] != (-1).toBigInteger()) continue
//         dist[d.u] = (i * 10.toBigInteger() + d.c.toBigInteger())
//         for (v in G[d.u]) {
//             q.offer(D2(dist[d.u], v))
//         }
//         _debug_println(dist)
//     }
//     for (i in 1 until N) {
//         println(dist[i].mod(MOD.toBigInteger()).toLong())
//     }
// //    data class D2(val i: Int, val p: Int, val d: D)
// //
// //    val q = PriorityQueue<D2>(compareBy({ it.i }, { it.d.c }))
// //    q.offer(D2(0, -1, D(0, 0)))
// //    val dist = sizedLongArray(N, LONG_INF)
// //    while (q.isNotEmpty()) {
// //        val (i, p, d) = q.poll()
// //        if (dist[d.u] != LONG_INF) continue
// //        var n = 0L
// //        if (p >= 0) {
// //            n += dist[p]
// //        }
// //        dist[d.u] = (n * 10 + d.c) % MOD
// //        for (v in G[d.u]) {
// //            q.offer(D2(i + 1, d.u, v))
// //        }
// //    }
// //    for (i in 1 until N) {
// //        println(dist[i])
// //    }
// }
