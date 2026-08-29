package com.github.ked4ma.competitive.atcoder.abc472

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.int.output.*
import com.github.ked4ma.competitive.common.models.unionfind.*
import com.github.ked4ma.competitive.common.number.inf.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    val (N, M) = nextIntList()
    val ab = times(M) {
        val (a, b) = nextIntList().map { it - 1 }
        a to b
    }

    val G = sizedArray(N) { mutableListOf<Int>() }
    val uf = UnionFind(N * 2)
    val black = sizedIntArray(N * 2)
    for (i in 0 until N) black[i] = 1

    var ok = -1
    for (i in 0 until M) {
        val (a, b) = ab[i]
        if (!uf.same(a, b + N)) {
            uf.unite(a, b + N)
            uf.unite(a + N, b)
            if (uf.same(a, a + N)) {
                _debug_println("here")
                ok = i
                break
            }
            G[a].add(b)
            G[b].add(a)
        }
    }
    if (ok == -1) {
        println(-1)
        return
    }
    val (a, b) = ab[ok]
    val dist = sizedIntArray(N, INT_INF)
    dist[b] = 0
    val q = ArrayDeque<Int>()
    q.add(b)
    while (q.isNotEmpty()) {
        val u = q.removeFirst()
        for (v in G[u]) {
            if (dist[v] < INT_INF) continue
            dist[v] = dist[u] + 1
            q.add(v)
        }
    }
    val ans = mutableListOf(a + 1)
    var x = a
    while (x != b) {
        for (v in G[x]) {
            if (dist[x] - 1 == dist[v]) {
                x = v
                ans.add(x + 1)
                break
            }
        }
    }
    println(ans.size)
    ans.println(" ")
}
