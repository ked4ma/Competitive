package com.github.ked4ma.competitive.atcoder.abc462

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import kotlin.math.abs
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    var (A, B, X, Y) = nextLongList()
    if (3 * A < B) {
        B = 3 * A
    } else if (A > 3 * B) {
        A = 3 * B
    }
    X = abs(X)
    Y = abs(Y)
    val Z = min(X, Y)

    val a1 = 2 * Z * A // >
    val a2 = 2 * Z * B // ^

    var ans = LONG_INF

    if (X >= Y) {
        val z = X - Z
        val z1 = (z + 1) / 2
        val z2 = z - z1
        val b = z1 * A + z2 * B
        ans = minOf(ans, a1 + b, a2 + b)
    } else {
        val z = Y - Z
        val z1 = (z + 1) / 2
        val z2 = z - z1
        val b = z1 * B + z2 * A
        ans = minOf(ans, a1 + b, a2 + b)
    }
    println(ans)
}
