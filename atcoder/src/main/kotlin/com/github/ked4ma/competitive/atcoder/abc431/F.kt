package com.github.ked4ma.competitive.atcoder.abc431

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.mod.*
import com.github.ked4ma.competitive.common.number.inf.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val MOD = MOD998244353
    val (N, D) = nextIntList()
    val A = listOf(INT_INF) + nextIntList().sorted().sortedDescending()
    _debug_println(A)
    var ans = 1L
    for (i in 1..N) {
        var l = 0
        var r = i
        _debug_println(N <= 5) { "before: $l $r" }
        while (l + 1 < r) {
            val m = (l + r) / 2
            if (A[i] >= A[m] - D) {
                r = m
            } else {
                l = m
            }
            _debug_println(N <= 5) { "inter: $l $r (${A[i]} > ${A[m]} - $D)" }
        }
        _debug_println(N <= 5) { "${A[i]} $l ${i - l}" }
        ans *= i - l
        ans %= MOD
    }
    val memo = sizedLongArray(200_005, -1L)
    memo[0] = 1L
    memo[1] = 1L
    fun p(i: Int): Long {
        if (memo[i] > -1) return memo[i]
        val res = (i * p(i - 1)) % MOD
        memo[i] = res
        return res
    }
    A.groupingBy { it }.eachCount().values.forEach { i ->
        ans = ans.divMod(p(i), MOD)
    }
    println(ans)
}
