package com.github.ked4ma.competitive.common.acl.graph.scc

import com.github.ked4ma.competitive.common.acl.internal.csr.*
import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.list.d1.*
import com.github.ked4ma.competitive.common.repeat.*
import java.util.*
import kotlin.math.min

// https://atcoder.github.io/ac-library/master/document_en/scc.html
// https://atcoder.github.io/ac-library/master/document_ja/scc.html
// tarjan's algorithm: https://qiita.com/AkariLuminous/items/a2c789cebdd098dcb503
class SCCGraph(val n: Int) {
    data class Edge(val to: Int)

    private val edges = mutableListOf<Pair<Int, Edge>>()

    fun addEdge(from: Int, to: Int) {
        edges.add(from to Edge(to))
    }

    private fun sccIds(): Pair<Int, IntArray> {
        val g = CSR(n, edges)
        var nowOrd = 0
        var groupNum = 0

        val vis = Stack<Int>()
        val low = sizedIntArray(n, 0)
        val ord = sizedIntArray(n, -1)
        val ids = sizedIntArray(n, 0)
        fun dfs(u: Int) {
            low[u] = nowOrd
            ord[u] = nowOrd
            nowOrd++
            vis.push(u)
            for (i in g.start[u] until g.start[u + 1]) {
                val to = g.elist[i].to
                if (ord[to] == -1) {
                    dfs(to)
                    low[u] = min(low[u], low[to])
                } else {
                    low[u] = min(low[u], ord[to])
                }
            }
            if (low[u] == ord[u]) {
                while (true) {
                    val v = vis.pop()
                    ord[v] = n
                    ids[v] = groupNum
                    if (u == v) break
                }
                groupNum++
            }
        }
        for (i in range(n)) {
            if (ord[i] == -1) dfs(i)
        }
        for (i in range(n)) {
            ids[i] = groupNum - 1 - ids[i]
        }
        return groupNum to ids
    }

    fun scc(): Array<List<Int>> {
        val (groupNum, ids) = sccIds()
        val counts = sizedIntArray(groupNum, 0)
        for (x in ids) counts[x]++
        val groups = sizedListOf(groupNum) { mutableListOf<Int>() }
        for (i in range(n)) {
            groups[ids[i]].add(i)
        }
        return groups.toTypedArray()
    }
}