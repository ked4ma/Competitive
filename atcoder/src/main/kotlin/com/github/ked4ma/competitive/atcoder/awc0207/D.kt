package com.github.ked4ma.competitive.atcoder.awc0207

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.min

fun main() {
    val N = nextInt()
    val AB = times(N) {
        val (A, B) = nextLongList()
        A to B
    }
    val G = sizedArray(N) { mutableListOf<Pair<Int, Long>>() }
    repeat(N - 1) {
        val (U, V, C) = nextIntList()
        G[U - 1].add(V - 1 to C.toLong())
        G[V - 1].add(U - 1 to C.toLong())
    }
    fun dfs(u: Int = 0, p: Int = -1): Pair<Long, Long> {
        var (a, b) = AB[u]
        for ((v, c) in G[u]) {
            if (v == p) continue
            val (a2, b2) = dfs(v, u)
            a += min(a2, b2 + c)
            b += min(a2 + c, b2)
        }
        return a to b
    }
    println(dfs().let { (a, b) -> min(a, b) })
}
