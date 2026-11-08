package com.github.ked4ma.competitive.atcoder.abc483

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val m = 500_005
    val mp = mutableMapOf<Pair<Int, Int>, Long>().withDefault { 0 }
    repeat(N) {
        val (A, B) = nextIntList()
        mp[A to B] = mp.getValue(A to B) + 1
        A to B
    }
    val d = sizedLongArray(m + 1)
    var now = 0L
    for ((p, x) in mp) {
        var (a, b) = p
        now += a.toLong() * x
        a = b - a
        val k = x * b
        while (a <= m) {
            d[a] += k
            a += b
        }
    }
    val ans = sizedLongArray(m + 1)
    for (i in 0 until m) {
        now -= d[i]
        ans[i] = now
        now += N
    }
    val Q = nextInt()
    repeat(Q) {
        val x = nextInt()
        println(ans[x])
    }
}
