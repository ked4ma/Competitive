package com.github.ked4ma.competitive.atcoder.awc0188

import com.github.ked4ma.competitive.common.array.long.d2.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import com.github.ked4ma.competitive.common.repeat.*
import java.util.*

fun main() {
    val (H, W) = nextIntList()
    val A = times(H) { nextLongList() }

    data class D(val h: Int, val w: Int)

    val dist = sized2DLongArray(H, W, LONG_INF)
    val q = PriorityQueue<Pair<D, Long>>(compareBy { it.second })
    q.offer(D(0, 0) to 0)
    val dirs = listOf(
        1 to 0,
        -1 to 0,
        0 to 1,
        0 to -1,
    )
    while (q.isNotEmpty()) {
        val (p, d) = q.poll()
        val (h, w) = p
        if (dist[h][w] != LONG_INF) continue
        dist[h][w] = d
        for ((dh, dw) in dirs) {
            val nh = h + dh
            val nw = w + dw
            if (nh !in 0 until H || nw !in 0 until W || dist[nh][nw] != LONG_INF) continue
            q.offer(D(nh, nw) to d + A[nh][nw])
        }
    }
    println(dist[H - 1][W - 1])
}
