package com.github.ked4ma.competitive.codeforces.`2198`

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.unionfind.*
import com.github.ked4ma.competitive.common.repeat.*

fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}


private fun solve() {
    val (n, m1, m2) = nextIntList()
    val edges = times(m1) {
        val (u, v) = nextIntList().map { it - 1 }
        u to v
    }
    val uf2 = UnionFind(n)
    repeat(m2) {
        val (u, v) = nextIntList().map { it - 1 }
        uf2.unite(u, v)
    }
    var ans = 0
    val uf = UnionFind(n)
    for ((u, v) in edges) {
        if (uf2.same(u, v)) {
            uf.unite(u, v)
        } else {
            ans++
        }
    }
    ans += uf.size() - uf2.size()
    println(ans)
//    val F = sizedArray(n) { mutableSetOf<Int>() }
//    val G = sizedArray(n) { mutableSetOf<Int>() }
//    repeat(m1) {
//        val (u, v) = nextIntList().map { it - 1 }
//        F[u].add(v)
//        F[v].add(u)
//    }
//    repeat(m2) {
//        val (u, v) = nextIntList().map { it - 1 }
//        G[u].add(v)
//        G[v].add(u)
//    }
//    var ans = 0
//    val vis = sizedBooleanArray(n)
//    for (i in 0 until n) {
//        if (vis[i]) continue
//        vis[i] = true
//        val queue = ArrayDeque<Int>()
//        queue.add(i)
//        while (queue.isNotEmpty()) {
//            val u = queue.removeFirst()
//            for (v in F[u]) {
//                if (v !in G[u]) ans++
//            }
//            for (v in G[u]) {
//                if (v !in F[u]) ans++
//                if (vis[v]) continue
//                vis[v] = true
//                queue.add(v)
//            }
//        }
//    }
//    println(ans / 2)
}
