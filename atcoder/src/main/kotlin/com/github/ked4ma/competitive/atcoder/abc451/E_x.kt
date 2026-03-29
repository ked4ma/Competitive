package com.github.ked4ma.competitive.atcoder.abc451

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.int.d2.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.unionfind.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = sized2DIntArray(N, N)
    // bucket sort like
    val edges = sizedArray(10000) { mutableListOf<Pair<Int, Int>>() }
    for (i in 0 until N - 1) {
        val a = nextIntList()
        for (j in i + 1 until N) {
            val c = a[j - (i + 1)]
            A[i][j] = c
            A[j][i] = c
            edges[c].add(i to j)
        }
    }
    val uf = UnionFind(N)
    val G = sizedArray(N) { mutableListOf<Int>() }
    for (list in edges) {
        for ((i, j) in list) {
            if (uf.same(i, j)) continue
            uf.unite(i, j)
            G[i].add(j)
            G[j].add(i)
        }
    }

    for (s in 0 until N) {
        fun dfs(u: Int, p: Int = -1, c: Int = 0): Boolean {
            for (v in G[u]) {
                if (v == p) continue
                val nc = c + A[u][v]
                _debug_println("$nc ${A[s][v]}")
                if (nc != A[s][v] || !dfs(v, u, nc)) return false
            }
            return true
        }
        if (!dfs(s)) {
            println("No")
            return
        }
    }
    println("Yes")
}
// fun main() {
//     val N = nextInt()
//     val A = sized2DIntArray(N, N)
//     for (i in 0 until N - 1) {
//         val a = nextIntList()
//         for (j in i + 1 until N) {
//             val c = a[j - (i + 1)]
//             A[i][j] = c
//             A[j][i] = c
//         }
//     }
//     val queue = PriorityQueue<Triple<Int, Int, Int>>(compareBy { it.third })
//     for (i in 1 until N) {
//         queue.offer(Triple(i, 0, A[0][i]))
//     }
//     val vis = sizedBooleanArray(N)
//     vis[0] = true
//     val G = sizedArray(N) { mutableListOf<Int>() }
//     while (queue.isNotEmpty()) {
//         val (u, p, _) = queue.poll()
//         if (vis[u]) continue
//         vis[u] = true
//         G[u].add(p)
//         G[p].add(u)
//         for (v in 0 until N) {
//             if (v == u || v == p || vis[v]) continue
//             queue.offer(Triple(v, u, A[u][v]))
//         }
//     }
//     _debug_println(G)
//
//     for (s in 0 until N) {
//         fun dfs(u: Int, p: Int = -1, c: Int = 0): Boolean {
//             for (v in G[u]) {
//                 if (v == p) continue
//                 val nc = c + A[u][v]
//                 _debug_println("$nc ${A[s][v]}")
//                 if (nc != A[s][v] || !dfs(v, u, nc)) return false
//             }
//             return true
//         }
//         if (!dfs(s)) {
//             println("No")
//             return
//         }
//     }
//     println("Yes")
// }
