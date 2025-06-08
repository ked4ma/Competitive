package com.github.ked4ma.competitive.atcoder.abc409

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.abs

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val X = nextLongList()
    val G = sizedArray(N) { mutableListOf<Pair<Int, Long>>() }
    repeat(N - 1) {
        val (u, v, w) = nextIntList()
        G[u - 1].add(v - 1 to w.toLong())
        G[v - 1].add(u - 1 to w.toLong())
    }

    fun dfs(u: Int, p: Int = -1): Pair<Long, Long> {
        var x = X[u]
        var c = 0L
        for ((v, w) in G[u]) {
            if (v == p) continue
            val (x2, c2) = dfs(v, u)
            x += x2
            c += c2 + abs(x2) * w
        }
        return x to c
    }
    println(dfs(0).second)

    // val dp = sized2DLongArray(N, 2, 0)
    // fun dfs(u: Int, p: Int = -1) {
    //     var x = X[u]
    //     var c = 0L
    //     for ((v, w) in G[u]) {
    //         if (v == p) continue
    //         dfs(v, u)
    //         c += dp[v][0] + abs(dp[v][1]) * w
    //         x += dp[v][1]
    //     }
    //     dp[u][0] = c
    //     dp[u][1] = x
    // }
    // dfs(0)
    // _debug_println(dp)

    // var ans = Long.MAX_VALUE
    // fun dfs2(u: Int, p: Int = -1) {
    //     ans = min(ans, dp[u][0])
    //     var c = dp[u][0]
    //     var x = dp[u][1]
    //     for ((v, w) in G[u]) {
    //         if (v == p) continue
    //         c -= (dp[v][0] + abs(dp[v][1])) * w
    //         x -= dp[v][1]
    //     }
    //     dp[u][0] = c
    //     dp[u][1] = x
    //     for ((v, w) in G[u]) {
    //         if (v == p) continue
    //         dp[v][0] += c + x * w
    //         dp[v][1] += x
    //     }
    // }
    // dfs2(0)
    // println(ans)
}
