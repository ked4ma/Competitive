package com.github.ked4ma.competitive.codeforces.`2266`

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.array.long.d1.chmin.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.prime.*
import com.github.ked4ma.competitive.common.number.inf.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val m = 200_000
    val p = primes(m).map { it.toInt() }
    val divisors = sizedArray(m + 1) { mutableListOf<Int>() }
    for (a in p) {
        for (x in a..m step a) {
            divisors[x].add(a)
        }
    }
    val T = nextInt()
    repeat(T) {
        solve(divisors)
    }
}

private fun solve(divisors: Array<MutableList<Int>>) {
    val (n, k) = nextIntList().let { (n, k) -> n to k.toLong() }
    val a = nextIntList()

    val dp = sizedLongArray(n + 1, LONG_INF)
    for (i in 1..n) {
        if (i <= k) {
            dp[i] = 0
            continue
        }
        for (x in divisors[i]) {
            dp.chmin(i, 1L + x.toLong() * dp[i / x])
        }
    }
    var ans = 0L
    for (i in 0 until n) {
        ans += dp[a[i]]
    }
    println(ans)
}
