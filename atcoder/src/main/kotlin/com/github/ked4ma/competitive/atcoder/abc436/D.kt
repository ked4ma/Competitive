package com.github.ked4ma.competitive.atcoder.abc436

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.int.d2.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W) = nextIntList()
    val S = times(H) { nextCharArray() }
    val warps = run {
        val arr = sizedArray(26) { mutableListOf<Pair<Int, Int>>() }
        for (h in 0 until H) {
            for (w in 0 until W) {
                val c = S[h][w]
                if (c !in 'a'..'z') continue
                arr[c - 'a'].add(h to w)
            }
        }
        arr
    }
    val dirs = listOf(
        1 to 0,
        -1 to 0,
        0 to 1,
        0 to -1,
    )
    val dist = sized2DIntArray(H, W, -1)
    dist[0][0] = 0
    val queue = ArrayDeque<Pair<Int, Int>>()
    queue.add(0 to 0)
    while (queue.isNotEmpty()) {
        val (h, w) = queue.removeFirst()
        val next = buildSet {
            for ((dh, dw) in dirs) {
                add(h + dh to w + dw)
            }
            val c = S[h][w]
            if (c in 'a'..'z' && warps[c - 'a'].isNotEmpty()) {
                for (to in warps[c - 'a']) {
                    add(to)
                }
                warps[c - 'a'].clear()
            }
        }
        for ((nh, nw) in next) {
            if (nh !in 0 until H || nw !in 0 until W || S[nh][nw] == '#' || dist[nh][nw] != -1) continue
            dist[nh][nw] = dist[h][w] + 1
            queue.addLast(nh to nw)
        }
    }
    println(dist[H - 1][W - 1])
}
