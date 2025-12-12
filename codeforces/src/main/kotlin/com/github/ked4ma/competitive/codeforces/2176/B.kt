package com.github.ked4ma.competitive.codeforces.`2176`

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
    val n = nextInt()
    val s = nextCharArray()
    val s2 = s + s
    var ans = 0
    var cnt = 0
    for (c in s2) {
        if (c == '0') {
            cnt++
        } else {
            ans = max(ans, cnt)
            cnt = 0
        }
    }
    println(max(ans, cnt))
}
