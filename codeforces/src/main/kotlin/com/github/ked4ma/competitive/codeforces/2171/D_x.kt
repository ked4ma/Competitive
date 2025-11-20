package com.github.ked4ma.competitive.codeforces.`2171`

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
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
    val n = nextInt()
    _debug_println("====")
    val p = nextIntList()
    val pre = buildList {
        var x = Int.MAX_VALUE
        for (i in 0 until n) {
            x = min(x, p[i])
            add(x)
        }
    }
    val suf = buildList {
        var x = 0
        for (i in n - 1 downTo 0) {
            x = max(x, p[i])
            add(x)
        }
    }.asReversed()
    _debug_println(pre)
    _debug_println(suf)
    for (i in 0 until n - 1) {
        if (pre[i] > suf[i + 1]) {
            println("No")
            return
        }
    }
    println("Yes")
}
