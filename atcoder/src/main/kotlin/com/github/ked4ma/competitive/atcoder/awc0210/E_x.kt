package com.github.ked4ma.competitive.atcoder.awc0210

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import kotlin.math.max
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextLongList()
    val G = sizedArray(N) { mutableListOf<Int>() }
    repeat(N - 1) {
        val (u, v) = nextIntList().map { it - 1 }
        G[u].add(v)
        G[v].add(u)
    }

    data class D(val c0: Long, val c1: Long, val c2: Long)

    fun dfs(u: Int = 0, p: Int = -1): D {
        var c0 = A[u]
        var s = 0L
        val c = mutableListOf(LONG_INF, LONG_INF)
        for (v in G[u]) {
            if (v == p) continue
            val (cc0, cc1, cc2) = dfs(v, u)
            c0 += minOf(cc0, cc1, cc2)
            // at leat on rest point
            s += min(cc0, cc2)
            // additional cost if v is set as rest point
            // if (cc0, cc2) = (7, 4), we need to pay extra cost 3 (7 - 3)
            // and if (cc0, cc2) = (3, 8), we don't need because we already pay cost for rest point. (3 - 8 < 0)
            c += max(0, cc0 - cc2)
        }
        c.sort()
        return D(c0, s + c[0], s + c[0] + c[1])
    }
    val (c0, _, c2) = dfs()
    println(min(c0, c2))
}
