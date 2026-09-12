package com.github.ked4ma.competitive.atcoder.awc0155

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.long.cumlative.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, D, S) = nextLongList().let { (N, D, S) -> Triple(N.toInt(), D, S.toInt() - 1) }
    val A = nextLongList()
    val aCum = A.cumulativeSum()
    var ans = 0L
    val m = N - S
    _debug_println(m)
    if (D >= m) {
        ans += aCum[N] - aCum[S]
        ans += ((D - m) / N) * aCum[N]
        ans += aCum[((D - m) % N).toInt()]
    } else {
        ans = aCum[(S + D).toInt()] - aCum[S]
    }
    println(ans)
}
