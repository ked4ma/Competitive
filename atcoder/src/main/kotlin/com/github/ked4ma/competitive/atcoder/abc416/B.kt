package com.github.ked4ma.competitive.atcoder.abc416

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.range.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = nextCharArray()
    val list = buildList {
        add(-1)
        for (i in range(S.size)) {
            if (S[i] == '#') add(i)
        }
        add(S.size)
    }
    _debug_println(list)
    val ans = S.copyOf()
    for ((l, r) in list.windowed(2, 1)) {
        if (l + 1 < r) {
            ans[l + 1] = 'o'
        }
    }
    println(ans.concatToString())
}
