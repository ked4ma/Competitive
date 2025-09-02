package com.github.ked4ma.competitive.atcoder.abc420

import com.github.ked4ma.competitive.common.array.boolean.d1.*
import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.unionfind.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val uf = UnionFind(N)
    val color = sizedBooleanArray(N)
    val cnt = sizedIntArray(N, 0)
    repeat(Q) {
        val query = nextIntList().map { it - 1 }
        when (query[0]) {
            0 -> {
                val u = query[1]
                val v = query[2]
                val uK = uf.find(u)
                val vK = uf.find(v)
                if (uK != vK) {
                    uf.unite(u, v)
                    val k = uf.find(u)
                    if (k == uK) {
                        cnt[k] += cnt[vK]
                    } else {
                        cnt[k] += cnt[uK]
                    }
                }
            }

            1 -> {
                val v = query[1]
                color[v] = !color[v]
                val k = uf.find(v)
                cnt[k] += if (color[v]) 1 else -1
            }

            2 -> {
                val v = query[1]
                val k = uf.find(v)
                println(if (cnt[k] > 0) "Yes" else "No")
            }
        }
    }
}
