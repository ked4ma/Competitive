package com.github.ked4ma.competitive.codeforces.`2185`

import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    var n = nextInt()
    val a = nextLongList().sorted().distinct()
    n = a.size
    var max = 0
    run {
        var cnt = 1
        var b = a[0]
        for (i in 1 until n) {
            if (b + 1 == a[i]) {
                cnt++
            } else {
                max = max(max, cnt)
                cnt = 1
            }
            b = a[i]
        }
        max = max(max, cnt)
    }
    println(max)
}
