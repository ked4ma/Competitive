package com.github.ked4ma.competitive.atcoder.abc392

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.unionfind.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val AB = times(M) {
        val (A, B) = nextIntList().map { it - 1 }
        A to B
    }
    val available = mutableListOf<Int>()
    val uf = UnionFind(N)
    for (i in range(M)) {
        val (A, B) = AB[i]
        if (uf.same(A, B)) {
            available.add(i)
        } else {
            uf.unite(A, B)
        }
    }
    _debug_println(available)
    val roots = uf.uniqueRoots.toMutableSet()
    _debug_println(roots)
    val cand = available.map { i ->
        val (A, B) = AB[i]
        val x = uf.find(A)
        Triple(i, A, x)
    }
    _debug_println(cand)
    var cnt = roots.size
    val ans = mutableListOf<String>()
    for ((i, A, x) in cand) {
        if (cnt == 0) break
        val j = roots.firstOrNull { !uf.same(it, x) } ?: continue
        ans.add("${i + 1} ${A + 1} ${j + 1}")
        roots.remove(j)
        uf.unite(j, x)
        cnt--
    }
    println(ans.size)
    println(ans.joinToString("\n"))
}
