package com.github.ked4ma.competitive.atcoder.abc420

import com.github.ked4ma.competitive.common.array.int.d3.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W) = nextIntList()
    val A = times(H) { nextCharArray() }
    var (sh, sw) = 0 to 0
    var (gh, gw) = 0 to 0
    for (i in 0 until H) {
        for (j in 0 until W) {
            if (A[i][j] == 'S') {
                sh = i
                sw = j
            }
            if (A[i][j] == 'G') {
                gh = i
                gw = j
            }
        }
    }
    val cost = sized3DIntArray(2, H, W, INT_INF)
    val queue = ArrayDeque<D>()
    queue.add(D(0, sh, sw, 0))
    val dirs = listOf(
        0 to 1,
        0 to -1,
        1 to 0,
        -1 to 0
    )
    while (queue.isNotEmpty()) {
        val (s, h, w, c) = queue.removeFirst()
        if (cost[s][h][w] < INT_INF) continue
        cost[s][h][w] = c
        if (h == gh && w == gw) continue
        for ((dh, dw) in dirs) {
            val nh = h + dh
            val nw = w + dw
            if (nh !in 0 until H || nw !in 0 until W) continue
            val ns = if (A[nh][nw] == '?') 1 - s else s
            if (
                A[nh][nw] == '#' ||
                ((ns == 0 && A[nh][nw] == 'x') || (ns == 1 && A[nh][nw] == 'o')) ||
                cost[ns][nh][nw] < INT_INF
            ) continue
            queue.add(D(ns, nh, nw, c + 1))
        }
    }
    var ans = min(cost[0][gh][gw], cost[1][gh][gw])
    if (ans == INT_INF) ans = -1
    println(ans)
}

private data class D(val s: Int, val h: Int, val w: Int, val c: Int)
