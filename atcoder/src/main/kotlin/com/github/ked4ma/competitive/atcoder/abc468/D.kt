package com.github.ked4ma.competitive.atcoder.abc468

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = nextCharArray()
    val n = S.size
    var ans = 0
    // odd
    for (i in 0 until n) {
        var l = i
        var r = i
        var diff = 0
        while (l >= 0 && r < n) {
            if (S[l] != S[r]) diff++
            if (diff > 1) break
            ans++
            l--
            r++
        }
    }
    // even
    for (i in 0 until n) {
        var l = i
        var r = i + 1
        var diff = 0
        while (l >= 0 && r < n) {
            if (S[l] != S[r]) diff++
            if (diff > 1) break
            ans++
            l--
            r++
        }
    }
    println(ans)
}
