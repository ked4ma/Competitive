package com.github.ked4ma.competitive.atcoder.abc413

import com.github.ked4ma.competitive.common.array.int.d2.*
import com.github.ked4ma.competitive.common.array.long.d2.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    data class Point(val h: Int, val w: Int)
    val (H, W, K) = nextIntList()
    val goals = times(K) {
        val (R, C) = nextIntList().map { it - 1 }
        R to C
    }.toSet()

    val dp = sized2DLongArray(H, W, LONG_INF)
    for ((R, C) in goals) {
        dp[R][C] = 0
    }
    val cnt = sized2DIntArray(H, W, 0)
    val queue = ArrayDeque<Point>()
    val dirs = listOf(
        Point(1, 0),
        Point(-1, 0),
        Point(0, 1),
        Point(0, -1),
    )
    for ((h, w) in goals) {
        for ((dh, dw) in dirs) {
            val nh = h + dh
            val nw = w + dw
            if (nh !in range(H) || nw !in range(W)) continue
            if (++cnt[nh][nw] == 2 && dp[nh][nw] == LONG_INF) {
                queue.add(Point(nh, nw))
            }
        }
    }
    var ans = 0L
    while (queue.isNotEmpty()) {
        val (h, w) = queue.removeFirst()
        if (dp[h][w] < LONG_INF) continue
        var f = LONG_INF
        var s = LONG_INF
        for ((dh, dw) in dirs) {
            val nh = h + dh
            val nw = w + dw
            if (nh !in range(H) || nw !in range(W)) continue
            if (dp[nh][nw] + 1 < f) {
                s = f
                f = dp[nh][nw] + 1
            } else if (dp[nh][nw] + 1 < s) {
                s = dp[nh][nw] + 1
            }
            if (++cnt[nh][nw] == 2 && dp[nh][nw] == LONG_INF) {
                queue.add(Point(nh, nw))
            }
        }
        dp[h][w] = s
        ans += s
    }
//    for (h in range(H)) {
//        for (w in range(W)) {
//            var n = dp[h][w]
//            if (n == LONG_INF) n = 0
//            ans += n
//        }
//    }
    println(ans)
    _debug_println(dp)
    _debug_println(cnt)
}
