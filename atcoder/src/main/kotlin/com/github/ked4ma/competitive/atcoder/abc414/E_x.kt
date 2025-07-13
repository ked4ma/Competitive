package com.github.ked4ma.competitive.atcoder.abc414

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.mod.*
import com.github.ked4ma.competitive.common.models.number.mod.long.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val MOD = MOD998244353
    val N = nextLong()
    var ans = (N + 1).toModLong(MOD) * N / 2
    _debug_println(ans)
    var b = 1L
    while (b <= N) {
        val y = N / b
        val nb = N / y + 1
        ans -= (nb - b).toModLong(MOD) * y
        b = nb
    }
    println(ans.toLong())
}
