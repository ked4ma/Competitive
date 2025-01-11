package com.github.ked4ma.competitive.atcoder.abc387

import com.github.ked4ma.competitive.common.array.int.d3.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W) = nextIntList()
    val S = times(H) { nextCharArray() }
    var s = 0 to 0
    var g = 0 to 0
    for (h in range(H)) {
        for (w in range(W)) {
            when (S[h][w]) {
                'S' -> s = h to w
                'G' -> g = h to w
            }
        }
    }
    val vis = sized3DIntArray(2, H, W, Int.MAX_VALUE)
    vis[0][s.first][s.second] = 0
    vis[1][s.first][s.second] = 0
    val queue = ArrayDeque<Triple<Int, Int, Int>>()
    queue.add(Triple(0, s.first, s.second))
    queue.add(Triple(1, s.first, s.second))
    while (queue.isNotEmpty()) {
        val (d, h, w) = queue.removeFirst()
        val dirs = if (d == 0) { // <-, ->
            listOf(
                1 to 0,
                -1 to 0,
            )
        } else {
            listOf(
                0 to 1,
                0 to -1,
            )
        }
        for ((dh, dw) in dirs) {
            val nh = h + dh
            val nw = w + dw
            if (nh !in range(H) || nw !in range(W) || S[nh][nw] == '#' || vis[1 - d][nh][nw] <= vis[d][h][w] + 1) continue
            vis[1 - d][nh][nw] = vis[d][h][w] + 1
            queue.add(Triple(1 - d, nh, nw))
        }
    }
    repeat(2) { d ->
        _debug_println("======")
        vis[d].forEach { _debug_println(it.joinToString(",")) }
    }
    val ans = min(vis[0][g.first][g.second], vis[1][g.first][g.second])
    println(if (ans == Int.MAX_VALUE) -1 else ans)
}
