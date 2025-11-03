package com.github.ked4ma.competitive.atcoder.abc409

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.range.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    val N = nextInt()
    val S = nextCharArray()
    var l = Int.MAX_VALUE
    var r = Int.MAX_VALUE
    for (i in range(N - 1)) {
        if (l == Int.MAX_VALUE) {
            if (S[i] > S[i + 1]) {
                l = i
                r = i + 1
            }
        } else if (S[l] >= S[i + 1]) {
            r++
        } else {
            break
        }
    }
    _debug_println("$l $r")
    if (l < Int.MAX_VALUE) {
        val c = S[l]
        for (i in l until r) {
            S[i] = S[i + 1]
        }
        S[r] = c
    }
    println(S.concatToString())
}
