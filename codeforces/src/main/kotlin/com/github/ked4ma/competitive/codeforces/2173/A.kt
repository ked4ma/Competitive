package com.github.ked4ma.competitive.codeforces.`2173`

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    val (n, k) = nextIntList()
    val s = nextCharArray()
    var i = k
    var ans = 0
    for (c in s) {
        when (c) {
            '0' -> {
                if (i >= k) {
                    ans++
                } else {
                    i++
                }
            }

            '1' -> {
                i = 0
            }
        }
    }
    println(ans)
}
