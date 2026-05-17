package com.github.ked4ma.competitive.atcoder.abc458

import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = nextCharArray()
    val n = S.size
    var ans = 0L
    for (i in 0 until n) {
        val c = S[i]
        if (c != 'C') continue
        val l = i
        val r = n - i - 1
        ans += min(l, r) + 1
    }
    println(ans)
}
