package com.github.ked4ma.competitive.atcoder.abc455

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val S = nextCharArray()

    fun f(co: LongArray): Long {
        var res = 0L
        var x = 0L
        val d = mutableMapOf<Long, Int>().withDefault { 0 }
        for (i in 0 until N) {
            d[x] = d.getValue(x) + 1
            x += co[S[i] - 'A']
            res += d.getValue(x)
        }
        return res
    }

    var ans = N.toLong() * (N + 1) / 2
    ans -= f(longArrayOf(1, -1, 0))
    ans -= f(longArrayOf(1, 0, -1))
    ans -= f(longArrayOf(0, 1, -1))
    val B = 1_000_000L
    ans += f(longArrayOf(B + 1, -1, -B)) * 2
    println(ans)
}
