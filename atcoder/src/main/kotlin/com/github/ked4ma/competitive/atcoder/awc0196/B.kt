package com.github.ked4ma.competitive.atcoder.awc0196

import com.github.ked4ma.competitive.common.array.char.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W) = nextIntList()
    val S = times(H) { nextCharArray() }
    val ans = sizedCharArray(H, 'x')
    for (i in 0 until H) {
        val s = S[i]
        if (s.count { it == 'T' } > 0) ans[i] = 'o'
    }
    println(ans.concatToString())
}
