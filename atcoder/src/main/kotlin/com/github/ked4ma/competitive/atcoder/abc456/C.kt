package com.github.ked4ma.competitive.atcoder.abc456

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.mod.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val MOD = MOD998244353
    val S = nextCharArray()
    val n = S.size
    var l = 0
    var r = 1
    var ans = 0L
    while (r < n) {
        while (r < n && S[r - 1] != S[r]) r++
        _debug_println("$l $r")
        val m = (r - l).toLong()
        ans += m * (m + 1) / 2
        ans %= MOD
        l = r
        r++
    }
    _debug_println("$l $r")
    if (r == n) {
        val m = (r - l).toLong()
        ans += m * (m + 1) / 2
        ans %= MOD
    }
    println(ans)
}
