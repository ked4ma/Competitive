package com.github.ked4ma.competitive.atcoder.abc447

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = nextCharArray() + ' '
    val T = nextCharArray() + ' '
    var i = 0
    var j = 0
    var ans = 0
    while (i < S.size && j < T.size) {
        val cs = S[i]
        val ct = T[j]
        when {
            cs == ct -> {
                i++
                j++
            }

            cs == 'A' -> {
                i++
                ans++
            }

            ct == 'A' -> {
                j++
                ans++
            }

            else -> {
                println(-1)
                return
            }
        }
    }
    println(ans)
}
