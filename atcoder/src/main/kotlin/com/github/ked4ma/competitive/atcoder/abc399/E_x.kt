package com.github.ked4ma.competitive.atcoder.abc399

import com.github.ked4ma.competitive.common.acl.graph.scc.*
import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val S = next()
    val T = next()
    println(solve(N, S, T))
}

private fun solve(N: Int, S: String, T: String): Int {
    if (S == T) return 0
    if (T.toSet().size == 26) return -1
    val edges = buildSet {
        for (i in range(N)) {
            add(S[i] - 'a' to T[i] - 'a')
        }
    }
    val inDeg = sizedIntArray(26, 0)
    val outDeg = sizedIntArray(26, 0)
    for ((u, v) in edges) {
        inDeg[v]++
        outDeg[u]++
    }
    if (outDeg.any { it > 1 }) return -1
    var ans = edges.size
    val g = SCCGraph(26)
    for ((u, v) in edges) {
        g.addEdge(u, v)
        if (u == v) ans--
    }
    for (grp in g.scc()) {
        if (grp.size >= 2 && grp.all { inDeg[it] <= 1 }) {
            ans++
        }
    }
    return ans
}
