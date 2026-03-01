package com.github.ked4ma.competitive.atcoder.abc447

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = nextCharArray()
    val cnt = sizedIntArray(26)
    for (c in S) {
        cnt[c - 'a']++
    }
    val max = cnt.max()
    val sb = StringBuilder()
    for (c in S) {
        if (cnt[c - 'a'] == max) continue
        sb.append(c)
    }
    println(sb)
}
