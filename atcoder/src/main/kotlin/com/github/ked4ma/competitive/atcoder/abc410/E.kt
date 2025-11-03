package com.github.ked4ma.competitive.atcoder.abc410

import com.github.ked4ma.competitive.common.array.int.d2.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.range.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, H, M) = nextIntList()

    val dp = sized2DIntArray(N + 1, H + 1, -1)
    dp[0][H] = M

    for (i in range(N)) {
        val (A, B) = nextIntList()
        for (j in range(H + 1)) {
            if (dp[i][j] == -1) continue
            if (A <= j) {
                dp[i + 1][j - A] = max(dp[i + 1][j - A], dp[i][j])
            }
            if (B <= dp[i][j]) {
                dp[i + 1][j] = max(dp[i + 1][j], dp[i][j] - B)
            }
        }
        if (dp[i + 1].max() < 0) {
            println(i)
            return
        }
    }
    println(N)

    //val AB = times(N) {
    //    val (A, B) = nextIntList()
    //    A to B
    //}
    //var map = mapOf(H to M)
    //var ans = 0
    //for ((A, B) in AB) {
    //    _debug_println(map)
    //    val next = mutableMapOf<Int, Int>().withDefault { 0 }
    //    var ok = false
    //    for ((h, m) in map) {
    //        if (h >= A) {
    //            ok = true
    //            if (h - A == 0 && m == 0) continue
    //            next[h - A] = max(next.getValue(h - A), m)
    //        }
    //        if (m >= B) {
    //            ok = true
    //            if (h == 0 && m - B == 0) continue
    //            next[h] = max(next.getValue(h), m - B)
    //        }
    //    }
    //    if (ok) ans++
    //    if (next.isEmpty()) break
    //    map = next
    //}
    //println(ans)
}
