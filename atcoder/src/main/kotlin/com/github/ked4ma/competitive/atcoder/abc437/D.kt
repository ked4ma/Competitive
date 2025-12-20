package com.github.ked4ma.competitive.atcoder.abc437

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.long.bound.*
import com.github.ked4ma.competitive.common.list.long.cumlative.*
import com.github.ked4ma.competitive.common.math.mod.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val MOD = MOD998244353
    val (N, M) = nextIntList()
    var A = nextLongList().sorted()
    var B = nextLongList().sorted()
    if (N > M) {
        A = B.also { B = A }
    }
    val bCum = B.cumulativeSum()
    _debug_println(A)
    _debug_println(B)
    var ans = 0L
    for (a in A) {
        val i = B.upperBound(a)
        _debug_println("$a $i")
        _debug_println("${bCum[i]} ${bCum.last() - bCum[i]}")
        ans = ans.plusMod(a * i - bCum[i], MOD)
        ans = ans.plusMod(bCum.last() - bCum[i] - a * (B.size - i), MOD)
    }
    println(ans)
}
