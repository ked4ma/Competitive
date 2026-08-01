package com.github.ked4ma.competitive.atcoder.abc468

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.mod.*
import com.github.ked4ma.competitive.common.models.number.mod.long.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    MOD = MOD998244353
    val N = nextInt()
    val A = nextLongList()
    var aSum = 0.toModLong()
    var aSum2 = A.sum().toModLong()
    var l = 0
    var r = N - 1
    var ans = 0.toModLong()
    for (i in 1..N) {
        if (l == r) {
            aSum += aSum2
        } else if (l < r) {
            aSum += aSum2
            aSum2 -= A[l]
            aSum2 -= A[r]
        } else {
            aSum -= aSum2
            aSum2 += A[l]
            aSum2 += A[r]
        }
        ans += aSum / i
        _debug_println("$i: $l $r: ${aSum.toLong()}: (${aSum2.toLong()})")
        l++
        r--
    }
    println(ans.toLong())
}
