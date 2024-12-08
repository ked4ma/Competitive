package com.github.ked4ma.competitive.atcoder.abc383

import com.github.ked4ma.competitive.common.array.long.d2.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, X, K) = nextIntList().let { (N, X, K) -> Triple(N, X, K.toLong()) }
    val PUC = times(N) {
        val (P, U, C) = nextLongList()
        Triple(P.toInt(), U, C.toInt())
    }.sortedBy { it.third }
    var dp1 = sized2DLongArray(X + 1, 2, 0L)
    var dp2 = sized2DLongArray(X + 1, 2, 0L)
    for (i in range(N)) {
        val cChange = i == 0 || PUC[i].third != PUC[i - 1].third
        val (p, u, _) = PUC[i]
        for (x in range(X).reversed()) {
            // not buy
            if (cChange) {
                dp2[x][0] = max(dp1[x][0], dp1[x][1])
                dp2[x][1] = 0
            } else {
                dp2[x][0] = dp1[x][0]
                dp2[x][1] = dp1[x][1]
            }
            // buy
            if (x + p > X) continue
            if (cChange) {
                dp2[x + p][1] = maxOf(dp2[x + p][1], dp1[x][0] + u + K, dp1[x][1] + u + K)
            } else {
                dp2[x + p][1] = max(dp2[x + p][1], dp1[x][0] + u + K)
                dp2[x + p][1] = max(dp2[x + p][1], dp1[x][1] + u)
            }
        }
        dp1 = dp2
        dp2 = dp1
    }
    var ans = 0L
    for (x in range(X + 1)) {
        ans = maxOf(ans, dp1[x][0], dp1[x][1])
    }
    println(ans)
}
