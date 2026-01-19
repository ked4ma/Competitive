package com.github.ked4ma.competitive.codeforces.`2185`

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.array.long.output.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    val (n, m, h) = nextIntList().let { (n, m, h) -> Triple(n, m, h.toLong()) }
    val a = nextLongList().toLongArray()
    var reset = 0
    val time = sizedIntArray(n)
    val add = sizedLongArray(n)
    for (i in 1..m) {
        val (b, c) = nextIntList().let { (b, c) -> b - 1 to c.toLong() }
        if (time[b] < reset) {
            add[b] = 0
            time[b] = i
        }
        if (a[b] + add[b] + c > h) {
            reset = i
            add[b] = 0
        } else {
            add[b] += c
        }
        time[b] = i
    }
    for (i in 0 until n) {
        if (time[i] >= reset) {
            a[i] += add[i]
        }
    }
    a.println(" ")
}
