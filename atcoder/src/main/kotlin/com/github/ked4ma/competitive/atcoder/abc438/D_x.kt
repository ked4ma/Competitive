package com.github.ked4ma.competitive.atcoder.abc438

import com.github.ked4ma.competitive.common.array.long.d2.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val arr = sized2DLongArray(N, 3, 0)
    repeat(3) { i ->
        nextLongList().forEachIndexed { j, n -> arr[j][i] = n }
    }
    val dp = sized2DLongArray(N, 3, -LONG_INF)
    dp[0][0] = arr[0][0]
    for (i in 1 until N) {
        for (j in 0 until 3) {
            var mx = dp[i - 1][j]
            if (j > 0) mx = max(mx, dp[i - 1][j - 1])
            dp[i][j] = mx + arr[i][j]
        }
    }
    println(dp.last().last())

//    val N = nextInt()
//    val A = nextLongList()
//    val B = nextLongList()
//    val C = nextLongList()
//    var ans = 0L
//    var sumA = A.sum()
//    var base = 0L
//    var diff = 0L
//    var maxDiff = -LONG_INF
//    for (x in N - 1 downTo 1) {
//        sumA -= A[x]
//        base += B[x]
//        diff += C[x] - B[x]
//        val maxBC = base + maxDiff
//        ans = max(ans, sumA + maxBC)
//        maxDiff = max(maxDiff, diff)
//    }
//    println(ans)

//    val N = nextInt()
//    val A = nextLongList()
//    val B = nextLongList()
//    val C = nextLongList()
//    val D = A.cumulativeSum()
//    val E = B.cumulativeSum()
//    val F = C.cumulativeSum()
//    val G = sizedLongArray(N + 1)
//    val H = sizedLongArray(N + 1)
//    val I = sizedLongArray(N + 1)
//    for (i in 1 until N + 1) {
//        G[i] = D[i] - E[i]
//        H[i] = E[i] - F[i]
//        I[i] = max(G[i], G[i - 1])
//    }
//    var mx = -LONG_INF
//    var ans = 0L
//    for (i in 1 until N) {
//        ans = max(ans, mx + H[i] + F[N])
//        mx = max(mx, G[i])
//    }
//    println(ans)
}
