package com.github.ked4ma.competitive.atcoder.awc0159

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.min

fun main() {
    val N = nextInt()
    val V = nextLongList()
    if (N == 1) {
        println(V[0])
        return
    }
    val P = nextIntList()
    val memo = V.toLongArray()
    for (i in (1 until N).reversed()) {
        val p = P[i - 1] - 1
        memo[p] += memo[i]
    }
    val sum = memo[0]
    var ans = sum
    for (i in 1 until N) {
        ans = min(ans, sum - memo[i])
    }
    _debug_println(memo)
    println(ans)
}
