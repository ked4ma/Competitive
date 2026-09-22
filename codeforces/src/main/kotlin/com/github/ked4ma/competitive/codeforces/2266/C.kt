package com.github.ked4ma.competitive.codeforces.`2266`

import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    val n = nextInt()
    val s = nextCharArray()
    if (s[0] == '1') {
        println(s.count { it == '0' })
        return
    }

    var i = 0
    while (i < n && s[i] == '0') i++
    var cnt = 0
    for (j in i until n) {
        when (s[j]) {
            '0' -> cnt++
        }
    }
    var cur = cnt
    var ans = cur
    for (j in i until n) { // j -> 0
        when (s[j]) {
            '0' -> {
                cnt--
                cur--
            }

            '1' -> cur++
        }
        ans = min(ans, cur)
    }
    println(ans)
}
