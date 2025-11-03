package com.github.ked4ma.competitive.atcoder.abc405

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import com.github.ked4ma.competitive.common.repeat.range.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W) = nextIntList()
    val S = times(H) { nextCharArray() }

    val queue = ArrayDeque<Pair<Int, Int>>()
    for (h in range(H)) {
        for (w in range(W)) {
            if (S[h][w] == 'E') queue.addLast(h to w)
        }
    }
    val dirs = listOf(
        Triple(1, 0, '^'),
        Triple(-1, 0, 'v'),
        Triple(0, 1, '<'),
        Triple(0, -1, '>'),
    )
    while (queue.isNotEmpty()) {
        val (h, w) = queue.removeFirst()
        for ((dh, dw, d) in dirs) {
            val nh = h + dh
            val nw = w + dw
            if (nh !in range(H) || nw !in range(W) || S[nh][nw] != '.') continue
            S[nh][nw] = d
            queue.addLast(nh to nw)
        }
    }
    println(S.joinToString("\n") { it.concatToString() })
}
