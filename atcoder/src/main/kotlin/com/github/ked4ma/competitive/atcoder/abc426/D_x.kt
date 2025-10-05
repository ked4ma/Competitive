package com.github.ked4ma.competitive.atcoder.abc426

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.debug._debug_println
import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) { solve() }
}

private fun solve() {
    val N = nextInt()
    val S = next()
    val zeroCnt = sizedIntArray(N + 1, 0)
    for (i in 0 until N) {
        zeroCnt[i + 1] = zeroCnt[i] + if (S[i] == '0') 1 else 0
    }
    var ans = Int.MAX_VALUE
    var l = 0
    var r = 0
    while (r < N) {
        while (r < N && S[l] == S[r]) r++
        val lZero = zeroCnt[l] - zeroCnt[0]
        val rZero = zeroCnt[N] - zeroCnt[r]
        val lOne = l - lZero
        val rOne = N - r - rZero
        ans = if (S[l] == '0') {
            min(ans, 2 * (lZero + rZero) + lOne + rOne)
        } else {
            min(ans, 2 * (lOne + rOne) + lZero + rZero)
        }
        _debug_println("$S $ans $l $r $lZero $lOne $rZero $rOne")
        l = r
    }
    println(ans)
}
