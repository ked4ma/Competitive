package com.github.ked4ma.competitive.atcoder.awc0160

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.int.bound.*
import com.github.ked4ma.competitive.common.models.tree.segment.normal.general.*
import com.github.ked4ma.competitive.common.repeat.*

// Note: I passed, but it was after the contest.

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    data class P(val c: Int, val h: Int, val i: Int)

    val N = nextInt()
    val CH = times(N) {
        val (C, H) = nextIntList()
        P(C - 1, H, it)
    }

    val tree = GeneralSegmentTree.getInstance<P, P>(
        n = N,
        op = { a, b ->
            if (a.h > b.h) a else b
        },
        mapping = { _, m -> m },
        e = P(-1, 0, -1)
    )
    tree.init(CH)
    val cArr = sizedArray(N) { mutableListOf<Int>() }
    for (i in 0 until N) {
        val (c, _) = CH[i]
        cArr[c].add(i)
    }
    _debug_println(tree.query(0, N))
    var ans = 0L
    fun dfs(l: Int = 0, r: Int = N) {
        if (l >= r) return
        val (c, _, i) = tree.query(l, r)
        val cl = cArr[c].lowerBound(l)
        val cr = cArr[c].lowerBound(r) - 1
        _debug_println("($l, $r): $c ($i): ${cArr[c]} -> ($cl, $cr)")
        ans += cr - cl
        dfs(l = l, r = i)
        dfs(l = i + 1, r = r)
    }
    dfs()
    println(ans)
    _debug_println(cArr)
}
