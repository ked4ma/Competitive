package com.github.ked4ma.competitive.atcoder.abc384

import com.github.ked4ma.competitive.common.array.boolean.d2.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W, X) = nextLongList().let { (H, W, X) -> Triple(H.toInt(), W.toInt(), X) }
    val (P, Q) = nextIntList().map { it - 1 }
    val S = times(H) { nextLongList() }

    val dirs = listOf(
        1 to 0,
        -1 to 0,
        0 to 1,
        0 to -1,
    )

    var ans = S[P][Q]
    val vis = sized2DBooleanArray(H, W, false)
    vis[P][Q] = true
    val queue = PriorityQueue<Pair<Int, Int>>(compareBy { (h, w) -> S[h][w] })
    for ((dh, dw) in dirs) {
        val nh = P + dh
        val nw = Q + dw
        if (nh in range(H) && nw in range(W)) {
            queue.offer(nh to nw)
            vis[nh][nw] = true
        }
    }
    while (queue.isNotEmpty() && queue.peek().let { (h, w) -> S[h][w] } < ans.toDouble() / X) {
        val (h, w) = queue.poll()
        ans += S[h][w]
        for ((dh, dw) in dirs) {
            val nh = h + dh
            val nw = w + dw
            if (nh in range(H) && nw in range(W) && !vis[nh][nw]) {
                queue.offer(nh to nw)
                vis[nh][nw] = true
            }
        }
    }
    println(ans)
}
