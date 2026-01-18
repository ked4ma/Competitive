package com.github.ked4ma.competitive.atcoder.abc441

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.int.output.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M, L, S, T) = nextIntList()
    val G = sizedArray(N) { mutableListOf<Pair<Int, Int>>() }
    repeat(M) {
        val (u, v, c) = nextIntList()
        G[u - 1].add(v - 1 to c)
    }
    var queue = mutableListOf(0 to 0)
    repeat(L) {
        var pre = mutableListOf<Pair<Int, Int>>()
        queue = pre.also { pre = queue }
        for ((u, c) in pre) {
            for ((v, cd) in G[u]) {
                if (c + cd <= T) {
                    queue.add(v to c + cd)
                }
            }
        }
        _debug_println(queue)
    }
    queue.filter { it.second in S..T }.map { it.first + 1 }.sorted().distinct().println(" ")
}
