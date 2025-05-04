package com.github.ked4ma.competitive.atcoder.abc404

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.unionfind.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val uf = UnionFind(N)
    val deg = sizedIntArray(N, 0)
    repeat(M) {
        val (A, B) = nextIntList().map { it - 1 }
        uf.unite(A, B)
        deg[A]++
        deg[B]++
    }
    _debug_println(deg)
    println(if (uf.uniqueRoots.size == 1 && deg.all { it == 2 }) "Yes" else "No")
}
