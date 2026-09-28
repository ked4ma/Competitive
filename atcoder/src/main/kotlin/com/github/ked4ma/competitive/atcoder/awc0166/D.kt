package com.github.ked4ma.competitive.atcoder.awc0166

import com.github.ked4ma.competitive.common.array.boolean.d2.*
import com.github.ked4ma.competitive.common.array.long.d2.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W) = nextIntList()
    val C = times(H) { nextLongList() }

    data class D(val h: Int, val w: Int, val t: Long)

    val q = PriorityQueue<D>(compareBy { (h, w, t) -> t + C[h][w] })
    val vis = sized2DBooleanArray(H, W)
    for (w in 0 until W) {
        q.offer(D(0, w, 0))
        q.offer(D(H - 1, w, 0))
        vis[0][w] = true
        vis[H - 1][w] = true
    }
    for (h in 1 until H - 1) {
        q.offer(D(h, 0, 0))
        q.offer(D(h, W - 1, 0))
        vis[h][0] = true
        vis[h][W - 1] = true
    }
    val dirs = listOf(
        1 to 0,
        -1 to 0,
        0 to 1,
        0 to -1,
    )
    val arr = sized2DLongArray(H, W)
    while (q.isNotEmpty()) {
        val (h, w, t) = q.poll()
        val nt = t + C[h][w]
        arr[h][w] = nt
        for ((dh, dw) in dirs) {
            val nh = h + dh
            val nw = w + dw
            if (nh !in 0 until H || nw !in 0 until W || vis[nh][nw]) continue
            q.offer(D(nh, nw, nt))
            vis[nh][nw] = true
        }
    }
    val Q = nextInt()
    repeat(Q) {
        val (r, k) = nextIntList().map { it - 1 }
        println(arr[r][k])
    }
}
