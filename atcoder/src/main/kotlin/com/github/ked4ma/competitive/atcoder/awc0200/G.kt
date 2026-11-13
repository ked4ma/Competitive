package com.github.ked4ma.competitive.atcoder.awc0200

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.array.int.d1.chmax.*
import com.github.ked4ma.competitive.common.array.int.output.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.unionfind.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val A = nextIntList()
    val uf = UnionFind(N)
    repeat(M) {
        val (u, v) = nextIntList().map { it - 1 }
        uf.unite(u, v)
    }
    val arr = A.toIntArray()
    for (i in 0 until N) {
        val j = uf.find(i)
        arr.chmax(j, A[i])
    }
    val ans = sizedIntArray(N)
    for (i in 0 until N) {
        ans[i] = arr[uf.find(i)]
    }
    ans.println("\n")
}
