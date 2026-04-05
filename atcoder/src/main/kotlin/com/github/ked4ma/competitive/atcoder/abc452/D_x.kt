package com.github.ked4ma.competitive.atcoder.abc452

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.int.bound.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = nextCharArray()
    val T = nextCharArray()
    val n = S.size
    val m = T.size
    val arr = sizedArray(26) { mutableListOf<Int>() }
    for (i in 0 until n) {
        arr[S[i] - 'a'].add(i)
    }
    var ans = 0L
    for (l in 0 until n) {
        var r = l
        for (c in T) {
            val narr = arr[c - 'a']
            val i = narr.lowerBound(r)
            if (i == narr.size) {
                r = n + 1
                break
            }
            r = narr[i] + 1
        }
        ans += r - l - 1
    }
    println(ans)
}
// fun main() {
//     val S = nextCharArray()
//     val T = nextCharArray()
//     val n = S.size
//     val m = T.size
//     val dp = sized2DLongArray(n + 1, m + 1)
//     var ans = n * (n + 1L) / 2
//     for (i in 0 until n) {
//         val c = S[i]
//         if (c == T[0]) {
//             dp[i + 1][1]++
//         } else {
//             dp[i + 1][0]++
//         }
//         for (j in 0 until m) {
//             if (c == T[j]) {
//                 dp[i + 1][j + 1] += dp[i][j]
//             } else {
//                 dp[i + 1][j] += dp[i][j]
//             }
//         }
//         dp[i + 1][m] += dp[i][m]
//         ans -= dp[i + 1].last()
//     }
//     _debug_println(dp)
//     _debug_println((n * (n + 1) / 2))
//     println(ans)
// }
//
