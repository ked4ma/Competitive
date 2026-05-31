package com.github.ked4ma.competitive.atcoder.abc460

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.gcd.ulong.*
import com.github.ked4ma.competitive.common.math.mod.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    val MOD = MOD998244353.toULong()
    val (n, m) = nextULongList()
    var l = 1UL
    var ans = 0UL
    for (i in 0 until 19) {
        val a = l * 10UL - 1UL
        val r = min(a, n)
        if (r < l) break
        val g = gcd(m, a)
        ans += (((n / (m / g)) % MOD) * ((r - l + 1UL) % MOD)) % MOD
        ans %= MOD
        l *= 10UL
    }
    println(ans)
}
