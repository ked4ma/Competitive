package com.github.ked4ma.competitive.atcoder.abc404

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = nextCharArray()
    val cnt = sizedIntArray(26, 0)
    for (c in S) {
        cnt[c - 'a']++
    }
    println('a' + cnt.indexOfFirst { it == 0 })
}
