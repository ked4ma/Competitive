package com.github.ked4ma.competitive.atcoder.abc466

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextIntList()
    val k2 = 2 * K + 1

    val dp = sizedLongArray(k2)
    repeat(N) {
        val (a, b) = nextLongList()
        repeat(k2) { j ->
            dp[j] += if (j % 2 == 0) a else b
        }
        repeat(k2 - 1) { j ->
            dp[j + 1] = max(dp[j + 1], dp[j])
        }
    }
    println(dp[k2 - 1])
}

// NOTE: my answer (AC)
// fun main() {
//     val (N, K) = nextIntList()
//     val AB = times(N) {
//         val (a, b) = nextLongList()
//         a to b
//     }
//     var dp = sized2DLongArray(2, K + 1, -LONG_INF)
//     dp[0][0] = 0
//     for (i in 0 until N) {
//         var pre = sized2DLongArray(2, K + 1, -LONG_INF)
//         dp = pre.also { pre = dp }
//         val (a, b) = AB[i]
//         for (j in 0 until 2) {
//             for (k in 0 until K + 1) {
//                 val now = pre[j][k]
//                 if (now == -LONG_INF) continue
//                 // flip
//                 run {
//                     val nj = 1
//                     val nk = if (j == 0) k + 1 else k
//                     if (nk <= K) {
//                         dp.chmax(nj, nk, now + (b - a))
//                     }
//                 }
//                 // not to flip
//                 run {
//                     val nj = 0
//                     val nk = k
//                     dp.chmax(nj, nk, now)
//                 }
//             }
//         }
//     }
//     var ans = 0L
//     for (j in 0 until 2) {
//         for (k in 0 until K + 1) {
//             if (dp[j][k] == -LONG_INF) continue
//             ans = max(ans, dp[j][k])
//         }
//     }
//     for (i in 0 until N) {
//         ans += AB[i].first
//     }
//     println(ans)
// }
