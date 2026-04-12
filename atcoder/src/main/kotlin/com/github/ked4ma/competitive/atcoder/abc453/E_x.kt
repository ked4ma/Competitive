package com.github.ked4ma.competitive.atcoder.abc453

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.combimation.mod.*
import com.github.ked4ma.competitive.common.math.mod.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.max
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    MOD = MOD998244353
    val N = nextInt()
    val d = sizedIntArray(N + 2)
    val d2 = sizedIntArray(N + 2)
    repeat(N) {
        var (L, R) = nextIntList()
        d[L]++
        d[R + 1]--
        L = max(L, N - R)
        R = min(R, N - L)
        if (L <= R) {
            d2[L]++
            d2[R + 1]--
        }
    }
    for (i in 0 until N + 1) {
        d[i + 1] += d[i]
        d2[i + 1] += d2[i]
    }

    val comb = CombinationMod(N)
    var ans = 0L
    for (x in 1 until N) {
        val y = N - x
        var a = d[x]
        var b = d[y]
        val c = d2[x]
        a -= c
        b -= c
        if (a + b + c != N) continue
        if (a > x || b > y) continue
        ans += comb.aCb(c, x - a)
        ans %= MOD
    }
    println(ans)
}
