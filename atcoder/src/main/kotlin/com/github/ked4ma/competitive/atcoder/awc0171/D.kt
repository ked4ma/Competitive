package com.github.ked4ma.competitive.atcoder.awc0171

import com.github.ked4ma.competitive.common.array.int.d3.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W) = nextIntList()
    val A = times(H) { nextIntList() }

    // 0 : >
    // 1 : v
    // 2 : <
    // 3 : ^
    val arr = sized3DIntArray(H, W, 4, INT_INF)
    arr[0][0][0] = 0
    arr[0][0][1] = 0
    val q = ArrayDeque<Triple<Int, Int, Int>>()
    q.add(Triple(0, 0, 0))
    q.add(Triple(0, 0, 1))
    while (q.isNotEmpty()) {
        val (h, w, t) = q.removeFirst()
        val ndir = if (t % 2 == 0) {
            listOf(Triple(1, 0, 1), Triple(-1, 0, 3))
        } else {
            listOf(Triple(0, 1, 0), Triple(0, -1, 2))
        }
        for ((dh, dw, nt) in ndir) {
            val nh = h + dh
            val nw = w + dw
            if (nh !in 0 until H || nw !in 0 until W || A[nh][nw] == 1 || arr[nh][nw][nt] <= arr[h][w][t] + 1) continue
            arr[nh][nw][nt] = arr[h][w][t] + 1
            q.add(Triple(nh, nw, nt))
        }
    }
    val ans = arr[H - 1][W - 1].min()
    if (ans == INT_INF) {
        println("NONE")
        return
    }
    println(ans)
}
