package com.github.ked4ma.competitive.atcoder.abc415

import com.github.ked4ma.competitive.common.array.long.d2.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import com.github.ked4ma.competitive.common.repeat.*
import com.github.ked4ma.competitive.common.repeat.range.*
import kotlin.math.max
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W) = nextIntList()
    val A = times(H) {
        nextLongList()
    }
    val P = nextLongList()

    // case: not to use binary search
    val dp = sized2DLongArray(H, W, LONG_INF)
    dp[H - 1][W - 1] = 0
    for (h in range(H).reversed()) {
        for (w in range(W).reversed()) {
            dp[h][w] += P[h + w] - A[h][w]
            dp[h][w] = max(dp[h][w], 0)
            if (h > 0) dp[h - 1][w] = min(dp[h - 1][w], dp[h][w])
            if (w > 0) dp[h][w - 1] = min(dp[h][w - 1], dp[h][w])
        }
    }
    println(dp[0][0])

    // fun judge(x: Long): Boolean {
    //     val dp = sized2DLongArray(H, W, -LONG_INF)
    //     dp[0][0] = x
    //     for (h in range(H)) {
    //         for (w in range(W)) {
    //             dp[h][w] += A[h][w] - P[h + w]
    //             if (dp[h][w] < 0) dp[h][w] = -LONG_INF
    //             if (h + 1 < H) dp[h + 1][w] = max(dp[h + 1][w], dp[h][w])
    //             if (w + 1 < W) dp[h][w + 1] = max(dp[h][w + 1], dp[h][w])
    //         }
    //     }
    //     return dp[H - 1][W - 1] >= 0
    // }
    // // val arr = sized2DLongArray(H, W, 0)
    // // fun judge(x: Long): Boolean {
    // //     for (h in range(H)) {
    // //         for (w in range(W)) {
    // //             var n: Long
    // //             if (h == 0 && w == 0) {
    // //                 n = A[h][w] + x
    // //             } else {
    // //                 n = buildList {
    // //                     if (h > 0) {
    // //                         add(A[h][w] + arr[h - 1][w])
    // //                     }
    // //                     if (w > 0) {
    // //                         add(A[h][w] + arr[h][w - 1])
    // //                     }
    // //                 }.max()
    // //             }
    // //             if (n < P[h + w]) {
    // //                 arr[h][w] = -LONG_INF
    // //             } else {
    // //                 arr[h][w] = n - P[h + w]
    // //             }
    // //         }
    // //     }
    // //     _debug_println(H == 4 && W == 7 && x == 0L) { arr }
    // //     return arr[H - 1][W - 1] >= 0
    // // }

    // var ng = -1L
    // var ok = LONG_INF
    // while (ng + 1 < ok) {
    //     val m = (ng + ok) / 2
    //     if (judge(m)) {
    //         ok = m
    //     } else {
    //         ng = m
    //     }
    // }
    // println(ok)
}
