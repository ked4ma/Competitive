package com.github.ked4ma.competitive.atcoder.abc383

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.unionfind.*
import com.github.ked4ma.competitive.common.repeat.*
import com.github.ked4ma.competitive.common.repeat.range.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M, K) = nextIntList()
    val uvw = times(M) {
        val (u, v, w) = nextIntList()
        Triple(u - 1, v - 1, w.toLong())
    }.sortedBy { it.third }
    val A = nextIntList()
    val B = nextIntList()
    val cntA = sizedIntArray(N, 0)
    val cntB = sizedIntArray(N, 0)
    for (i in range(K)) {
        cntA[A[i] - 1]++
        cntB[B[i] - 1]++
    }

    var ans = 0L
    val uf = UnionFind(N)
    for ((u, v, w) in uvw) {
        if (uf.same(u, v)) continue
        val rootU = uf.find(u)
        val rootV = uf.find(v)
        uf.unite(u, v)
        val nextRoot = uf.find(u)
        cntA[nextRoot] = cntA[rootU] + cntA[rootV]
        cntB[nextRoot] = cntB[rootU] + cntB[rootV]
        val cnt = min(cntA[nextRoot], cntB[nextRoot])
        ans += w * cnt
        cntA[nextRoot] -= cnt
        cntB[nextRoot] -= cnt
    }
    println(ans)
}
