package com.github.ked4ma.competitive.atcoder.awc0169

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.array.int.output.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.unionfind.*
import com.github.ked4ma.competitive.common.repeat.*

fun main() {
    val (N, K, Q) = nextIntList()
    val (A, B) = times(K) {
        val (A, B) = nextIntList()
        A to B
    }.unzip().let { (A, B) -> A.toIntArray() to B.toIntArray() }
    fun IntArray.cpSort() = this.copyOf().also { it.sort() }
    var C = A.cpSort()
    var D = B.cpSort()
    val ans = sizedIntArray(K)
    repeat(Q) {
        val (X, P, V) = nextIntList()
        when (X) {
            1 -> {
                A[P - 1] = V
                C = A.cpSort()
            }

            2 -> {
                B[P - 1] = V
                D = B.cpSort()
            }
        }
        val map = mutableMapOf<Int, Int>()
        run {
            for (c in C) {
                map[c] = 0
            }
            for (d in D) {
                map[d] = 0
            }
            var x = 0
            for (k in map.keys) {
                map[k] = x++
            }
        }
        val uf = UnionFind(map.size)
        for (i in 0 until K) {
            val c = map.getValue(C[i])
            val d = map.getValue(D[i])
            uf.unite(c, d)
        }
        for (i in 0 until K) {
            ans[i] = uf.size(map.getValue(C[i])) % 2
        }
        ans.println(" ")
    }
}
