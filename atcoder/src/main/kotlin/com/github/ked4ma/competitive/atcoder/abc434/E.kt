package com.github.ked4ma.competitive.atcoder.abc434

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.unionfind.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val LR = times(N) {
        val (X, R) = nextIntList()
        X - R to X + R
    }
    val values = LR.flatMap { it.toList() }.sorted().distinct()
    val revMap = buildMap {
        for (i in 0 until values.size) {
            this[values[i]] = i
        }
    }
    _debug_println(values)
    _debug_println(revMap)
    val links = sizedIntArray(values.size, 0)
    val uf = UnionFind(values.size)
    for ((L, R) in LR) {
        val l = revMap.getValue(L)
        val r = revMap.getValue(R)
        val root1 = uf.find(l)
        val root2 = uf.find(r)
        if (uf.same(l, r)) {
            links[root1]++
        } else {
            uf.unite(l, r)
            links[uf.find(l)] = links[root1] + links[root2] + 1
        }
    }
    var ans = 0
    _debug_println(links)
    _debug_println(uf.uniqueRoots)
    for (root in uf.uniqueRoots) {
        _debug_println("${uf.size(root)} ${links[root]}")
        ans += min(uf.size(root), links[root])
    }
    println(ans)
}
