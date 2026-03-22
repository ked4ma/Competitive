package com.github.ked4ma.competitive.atcoder.abc450

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.unionfind.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W) = nextIntList()
    val N = H * W
    val S = times(H) { nextCharArray() }

    val out = N
    val uf = UnionFind(N + 1)

    val dirs = listOf(
        0 to 1,
        0 to -1,
        1 to 0,
        -1 to 0,
    )
    for (h in 0 until H) {
        for (w in 0 until W) {
            if (S[h][w] == '#') continue
            for ((dh, dw) in dirs) {
                val nh = h + dh
                val nw = w + dw
                if (nh !in 0 until H || nw !in 0 until W) {
                    uf.unite(h * W + w, out)
                } else if (S[nh][nw] == '.') {
                    uf.unite(h * W + w, nh * W + nw)
                }
            }
        }
    }
    val ans = mutableSetOf<Int>()
    for (h in 0 until H) {
        for (w in 0 until W) {
            if (S[h][w] == '#') continue
            val i = h * W + w
            if (uf.same(i, out)) continue
            ans.add(uf.find(i))
        }
    }
    println(ans.size)
}
