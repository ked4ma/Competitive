package com.github.ked4ma.competitive.atcoder.abc451

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.unionfind.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()

    val uf = UnionFind(N * 2)
    val black = sizedIntArray(N * 2)
    for (i in 0 until N) black[i] = 1

    fun merge(a: Int, b: Int) {
        val x = black[uf.find(a)] + black[uf.find(b)]
        uf.unite(a, b)
        black[uf.find(a)] = x
    }

    fun get(a: Int): Int {
        return min(black[uf.find(a)], black[uf.find(a + N)])
    }

    var ok = true
    var ans = 0
    repeat(Q) {
        val (u, v) = nextIntList().map { it - 1 }
        if (!uf.same(u, v + N)) {
            ans -= get(u) + get(v)
            merge(u, v + N)
            merge(u + N, v)
            ans += get(u)
            if (uf.same(u, u + N)) ok = false
        }
        println(if (ok) ans else -1)
    }
}
