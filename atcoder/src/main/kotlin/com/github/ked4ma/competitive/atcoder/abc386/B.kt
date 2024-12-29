package com.github.ked4ma.competitive.atcoder.abc386

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = nextCharArray()
    var i = 0
    var ans = 0
    while (i < S.size) {
        if (i + 1 < S.size && S[i] == '0' && S[i + 1] == '0') {
            ans ++
            i += 2
        } else {
            i++
            ans++
        }
    }
    println(ans)
}
