package com.github.ked4ma.competitive.atcoder.abc465

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.mod.*
import com.github.ked4ma.competitive.common.number.int.bit.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    MOD = MOD998244353
    val N = nextCharArray()
    val m = N.size

    // a: x3
    // b: contains '3'
    // c: kind of digit
    data class D(val j: Int, val a: Int, val c: Int)

    var dp = mutableMapOf(D(0, 0, 0) to 1L).withDefault { 0 }
    for (i in 0 until m) {
        var pre = mutableMapOf<D, Long>().withDefault { 0 }
        dp = pre.also { pre = dp }
        val x = N[i] - '0'
        for ((d, now) in pre) {
            if (now == 0L) continue
            val (j, a, c) = d
            for (y in 0 until 10) {
                var nj = j
                if (j == 0) {
                    if (y < x) nj = 1
                    if (y > x) continue
                }
                // x3
                val na = (10 * a + y) % 3
                // kind of digit
                val nc = if (c == 0 && y == 0) 0 else c or (1 shl y)
                val nd = D(nj, na, nc)
                dp[nd] = (dp.getValue(nd) + now) % MOD
            }
        }
    }

    var ans = -1L
    for ((d, n) in dp) {
        if (n == 0L) continue
        val (_, a, c) = d
        var cnt = 0
        if (a == 0) cnt++
        if (c.bit(3)) cnt++
        if (c.countOneBits() == 3) cnt++
        if (cnt == 1) {
            ans += n
            ans %= MOD
        }
    }
    println(ans)
}

// NOTE: submitted code. (passed)
// fun main() {
//     MOD = MOD998244353
//     val N = nextCharArray()
//     val m = N.size
//
//     // a: x3
//     // b: contains '3'
//     // c: kind of digit
//     val dp = sized2DArray(m + 1, 2) { sized3DLongArray(3, 2, 1 shl 10) }
//     dp[0][0][0][0][0] = 1
//     for (i in 0 until m) {
//         val x = N[i] - '0'
//         _debug_println(x)
//         for (j in 0 until 2) {
//             for (a in 0 until 3) {
//                 for (b in 0 until 2) {
//                     for (c in 0 until (1 shl 10)) {
//                         val now = dp[i][j][a][b][c]
//                         if (now == 0L) continue
//                         for (y in 0 until 10) {
//                             var nj = j
//                             if (j == 0) {
//                                 if (y < x) nj = 1
//                                 if (y > x) continue
//                             }
//                             // x3
//                             val na = (10 * a + y) % 3
//                             // contains '3'
//                             val nb = if (b == 1 || y == 3) 1 else 0
//                             // kind of digit
//                             val nc = if (c == 0 && y == 0) 0 else c or (1 shl y)
//                             dp[i + 1][nj][na][nb][nc] += now
//                             dp[i + 1][nj][na][nb][nc] %= MOD
//                         }
//                     }
//                 }
//             }
//         }
//     }
//     var ans = -1L
//     for (j in 0 until 2) {
//         for (a in 0 until 3) {
//             for (b in 0 until 2) {
//                 for (c in 0 until (1 shl 10)) {
//                     val n = dp[m][j][a][b][c]
//                     if (n == 0L) continue
//                     var cnt = 0
//                     if (a == 0) cnt++
//                     if (b == 1) cnt++
//                     if (c.countOneBits() == 3) cnt++
//                     if (cnt == 1) {
//                         ans += n
//                         ans %= MOD
//                     }
//                 }
//             }
//         }
//     }
//     println(ans)
// }
