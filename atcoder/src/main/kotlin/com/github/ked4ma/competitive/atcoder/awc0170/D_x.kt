package com.github.ked4ma.competitive.atcoder.awc0170

import com.github.ked4ma.competitive.common.array.int.d2.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.gcd.long.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val XY = times(N) {
        val (X, Y) = nextLongList()
        X to Y
    }
    var ans = 0L
    for (i in 0 until N) {
        val cnt = sized2DIntArray(2, 2)
        val dict = mutableMapOf<Pair<Long, Long>, Int>().withDefault { 0 }
        val (xi, yi) = XY[i]
        for (j in 0 until i) {
            val (xj, yj) = XY[j]
            var x = xj - xi
            var y = yj - yi
            cnt[x.mod(2)][y.mod(2)]++
            val g = gcd(x, y)
            x /= g
            y /= g
            if (x < 0 || (x == 0L && y < 0)) {
                x = -x
                y = -y
            }
            dict[x to y] = dict.getValue(x to y) + 1
        }
        ans += i * (i - 1) / 2
        ans -= cnt[0][1] * cnt[1][0] + cnt[0][1] * cnt[1][1] + cnt[1][0] * cnt[1][1]
        // parallel
        for ((_, c) in dict) {
            ans -= c * (c - 1) / 2
        }
    }
    println(ans)
}
