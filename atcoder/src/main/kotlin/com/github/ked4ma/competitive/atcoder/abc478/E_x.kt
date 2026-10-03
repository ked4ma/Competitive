package com.github.ked4ma.competitive.atcoder.abc478

import com.github.ked4ma.competitive.common.acl.graph.scc.*
import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.array.int.output.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val scc = SCCGraph(N)
    val lt = mutableListOf<Pair<Int, Int>>()
    repeat(Q) {
        val (t, u, v) = nextIntList()
        scc.addEdge(u - 1, v - 1)
        if (t == 1) lt.add(u - 1 to v - 1)
    }

    val ans = sizedIntArray(N)
    scc.scc().forEachIndexed { i, component ->
        for (x in component) {
            ans[x] = i + 1
        }
    }
    for ((u, v) in lt) {
        if (ans[u] >= ans[v]) {
            println("No")
            return
        }
    }
    println("Yes")
    ans.println(" ")
}
