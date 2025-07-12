package com.github.ked4ma.competitive.atcoder.abc412

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.array.permutation.int.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val edges = times(M) {
        var (A, B) = nextIntList().map { it - 1 }
        if (A > B) A = B.also { B = A }
        A to B
    }.toSet()

    // 1
    var ans = Int.MAX_VALUE
    val g = sizedIntArray(N) { it }
    while (true) {
        if (!g.nextPermutation()) break
        val set = edges(g)
        ans = min(ans, ((edges + set) - (edges.intersect(set))).size)
    }
    _debug_println(ans)
    val all = range(N).toSet()
    // n = 3
    if (N >= 6) {
        for (i in range(N - 2)) {
            for (j in i + 1 until N - 1) {
                for (k in j + 1 until N) {
                    val a = setOf(i, j, k)
                    val b = all - a
                    ans = min(ans, calc(edges, a, b))
                }
            }
        }
    }
    _debug_println(ans)
    if (N == 8) {
        for (i in range(N - 3)) {
            for (j in i + 1 until N - 2) {
                for (k in j + 1 until N - 1) {
                    for (l in k + 1 until N) {
                        val a = setOf(i, j, k, l)
                        val b = all - a
                        ans = min(ans, calc(edges, a, b))
                    }
                }
            }
        }
    }
    println(ans)
}

private fun calc(origin: Set<Pair<Int, Int>>, a: Set<Int>, b: Set<Int>): Int {
    var res = Int.MAX_VALUE
    val arr = a.sorted().toIntArray()
    val arr2 = b.sorted().toIntArray()
    while (true) {
        if (!arr.nextPermutation()) break
        val set = edges(arr)
        arr2.sort()
        while (true) {
            if (!arr2.nextPermutation()) break
            val set2 = set + edges(arr2)
            res = min(res, ((origin + set2) - (origin.intersect(set2))).size)
        }
    }
    return res
}

private fun edges(g: IntArray): Set<Pair<Int, Int>> {
    val n = g.size
    val set = buildSet {
        for (i in range(n)) {
            var l = g[i]
            var r = g[(i + 1) % n]
            if (l > r) l = r.also { r = l }
            add(l to r)
        }
    }
    return set
}
