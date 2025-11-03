package com.github.ked4ma.competitive.atcoder.abc397

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.range.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = nextCharArray()
    var ans = 0
    for (i in range(S.size)) {
        if ((i + ans) % 2 == 0 && S[i] == 'o') {
            ans++
        } else if ((i + ans) % 2 == 1 && S[i] == 'i') {
            ans++
        }
    }
    if ((S.size + ans) % 2 == 1) ans++
    println(ans)
}
