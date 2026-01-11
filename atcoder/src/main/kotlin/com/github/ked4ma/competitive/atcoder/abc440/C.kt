package com.github.ked4ma.competitive.atcoder.abc440

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.long.cumlative.*
import com.github.ked4ma.competitive.common.number.inf.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    val (N, W) = nextIntList()
    val C = nextIntList()
    val arr = sizedLongArray(2 * W, 0)
    for (i in 0 until N) {
        arr[(i + 1) % (2 * W)] += C[i]
    }
    _debug_println(arr)
    val cum = (arr + arr).toList().cumulativeSum()
    var ans = LONG_INF
    for (i in 0 until 2 * W) {
        ans = min(ans, cum[i + W] - cum[i])
    }
    println(ans)
}
