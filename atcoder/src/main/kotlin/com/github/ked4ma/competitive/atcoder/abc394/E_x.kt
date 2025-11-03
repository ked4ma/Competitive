package com.github.ked4ma.competitive.atcoder.abc394

import com.github.ked4ma.competitive.common.array.int.d2.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import com.github.ked4ma.competitive.common.repeat.range.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val S = times(N) { nextCharArray() }

    val dist = sized2DIntArray(N, N, Int.MAX_VALUE / 2)
    val queue = ArrayDeque<Pair<Int, Int>>()
    fun push(s: Int, t: Int, d: Int) {
        if (dist[s][t] < Int.MAX_VALUE / 2) return
        dist[s][t] = d
        queue.addLast(s to t)
    }
    for (i in range(N)) {
        push(i, i, 0)
    }
    for (i in range(N)) {
        for (j in range(N)) {
            if (S[i][j] != '-') push(i, j, 1)
        }
    }
    while (queue.isNotEmpty()) {
        val (s, t) = queue.removeFirst()
        for (ns in range(N)) {
            for (nt in range(N)) {
                if (S[ns][s] == '-') continue
                if (S[t][nt] == '-') continue
                if (S[ns][s] != S[t][nt]) continue
                push(ns, nt, dist[s][t] + 2)
            }
        }
    }
    dist.joinToString("\n") { row ->
        row.map { if (it == Int.MAX_VALUE / 2) -1 else it }.joinToString(" ")
    }.let {
        println(it)
    }
}
