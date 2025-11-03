package com.github.ked4ma.competitive.atcoder.abc403

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.range.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextCharArray()
    val U = nextCharArray()
    for (i in range(T.size - U.size + 1)) {
        var ok = true
        for (j in range(U.size)) {
            if (T[i + j] != '?' && T[i + j] != U[j]) {
                ok = false
                break
            }
        }
        if (ok) {
            println("Yes")
            return
        }
    }
    println("No")
}
