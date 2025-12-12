package com.github.ked4ma.competitive.atcoder.abc435

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.tree.segment.*
import kotlin.math.abs
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val P = nextLongList()
    val pRev = P.withIndex().associate { it.value to it.index }
    val segTree = SegmentTree.RAQ_RMQ(N)
    segTree.init(P)
    val memo = mutableMapOf<Pair<Int, Int>, Pair<Int, Long>>()
    fun dfs(l: Int, r: Int): Pair<Int, Long> {
        if (l to r in memo) return memo.getValue(l to r)
        val i = pRev.getValue(segTree.query(l, r))
        _debug_println(i)
        var score = 0L
        // l
        if (l < i) {
            _debug_println("$l until $r: $l until $i")
            val (ni, c) = dfs(l, i)
            score = max(score, abs(ni - i) + c)
        }
        // r
        if (i + 1 < r) {
            _debug_println("$l until $r: ${i + 1} until $r")
            val (ni, c) = dfs(i + 1, r)
            score = max(score, abs(ni - i) + c)
        }
        memo[l to r] = i to score
        _debug_println("$l until $r: $memo")
        return i to score
    }
    println(dfs(0, N).second)
}
