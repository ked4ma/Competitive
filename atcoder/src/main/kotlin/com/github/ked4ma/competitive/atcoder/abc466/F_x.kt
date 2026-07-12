package com.github.ked4ma.competitive.atcoder.abc466

import com.github.ked4ma.competitive.common.input.default.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    val (N, X) = nextLongList().let { (N, X) -> N.toInt() to X }
    val A = nextLongList()
    val q = PriorityQueue<Pair<Long, Long>>(compareByDescending { it.first })
    q.offer(X + 1 to 1)
    for (i in 0 until N) {
        var num = 0L
        while (q.peek().first > A[i]) {
            val (w, c) = q.poll()
            num += w / A[i] * c
            q.offer(w % A[i] to c)
        }
        q.offer(A[i] to num)
    }
    var ans = 0L
    while (q.isNotEmpty()) {
        val (w, c) = q.poll()
        if (w == 0L) continue
        ans += c
    }
    println(ans - 1)
}

// wrong answer (not submitted)
// private fun solve() {
//     val (N, X) = nextLongList().let { (N, X) -> N.toInt() to (X + 1).toString() }
//     val m = X.length
//     val A = buildList {
//         val l = nextLongList()
//         add(l[0])
//         for (i in 1 until N) {
//             if (last() > l[i]) add(l[i])
//         }
//     }
//     _debug_println(A)
//     var dp = sizedArray(2) { mutableMapOf<Long, Long>().withDefault { 0 } }
//     dp[0][0] = 1
//     for (i in 0 until m) {
//         val n = X[i] - '0'
//         var pre = sizedArray(2) { mutableMapOf<Long, Long>().withDefault { 0 } }
//         dp = pre.also { pre = dp }
//         for (j in 0 until 2) {
//             for ((k, now) in pre[j]) {
//                 for (x in 0 until 10) {
//                     var nj = j
//                     if (j == 0) {
//                         if (x > n) continue
//                         if (x < n) nj = 1
//                     }
//                     var nk = 10 * k + x
//                     for (a in A) {
//                         nk %= a
//                     }
//                     dp[nj][nk] = dp[nj].getValue(nk) + now
//                 }
//             }
//         }
//         _debug_println("$n ${dp[0]}")
//     }
//     _debug_println(dp[0])
//     println(dp[1].getValue(0) - 1)
// }
//
