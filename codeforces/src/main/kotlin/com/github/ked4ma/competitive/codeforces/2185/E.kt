package com.github.ked4ma.competitive.codeforces.`2185`

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.array.int.output.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import kotlin.math.max
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    val (n, m, k) = nextIntList()
    val a = nextLongList().sorted()
    val b = listOf(-LONG_INF) + nextLongList().sorted() + listOf(LONG_INF)
    val s = nextCharArray()
    val rs = sizedArray(k + 2) { 0L..0L }
    rs[k + 1] = -LONG_INF..LONG_INF
    run {
        var i = 0L
        var min = 0L
        var max = 0L
        for (j in 0 until k) {
            val c = s[j]
            when (c) {
                'L' -> {
                    i--
                    min = min(min, i)
                }

                'R' -> {
                    i++
                    max = max(max, i)
                }
            }
            rs[j + 1] = min..max
        }
        min..max
    }
    _debug_println(rs)
    val ans = sizedIntArray(k)
    var i = 0
    for (x in a) {
        while (b[i + 1] < x) i++
        val l = b[i]
        val r = b[i + 1]
        _debug_println("$x: $l..$r")
        var ok = 0
        var ng = k + 1
        while (ok + 1 < ng) {
            val m = (ok + ng) / 2
            val range = rs[m]
            val l2 = x + range.first
            val r2 = x + range.last
            if (l < l2 && r2 < r) {
                ok = m
            } else {
                ng = m
            }
        }
        if (ng <= k) {
            ans[ng - 1]--
        }
    }
    ans[0] += n
    for (j in 1 until k) {
        ans[j] += ans[j - 1]
    }
    ans.println(" ")
}
