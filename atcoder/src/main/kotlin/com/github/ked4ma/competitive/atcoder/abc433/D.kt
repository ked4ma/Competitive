package com.github.ked4ma.competitive.atcoder.abc433

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val A = nextList()

    var ans = 0L
    val leftMap = sizedArray(10) { mutableMapOf<Long, Long>().withDefault { 0 } }
    val rightMap = sizedArray(10) { mutableMapOf<Long, Long>().withDefault { 0 } }
    for (a in A) {
        val l = a.length
        val n = a.toLong()
        var rem = n % M
        // xxx|n
        ans += leftMap[l - 1].getValue((M - rem) % M)
        rightMap[l - 1][rem] = rightMap[l - 1].getValue(rem) + 1
        // n|xxx
        for (p in 1..10) {
            rem *= 10
            rem %= M
            ans += rightMap[p - 1].getValue((M - rem) % M)
            leftMap[p - 1][rem] = leftMap[p - 1].getValue(rem) + 1
        }
        _debug_println("----- $a -----")
        _debug_println(leftMap)
        _debug_println(rightMap)
    }
    println(ans)
}
