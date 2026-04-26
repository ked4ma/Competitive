package com.github.ked4ma.competitive.atcoder.abc455

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W) = nextIntList()
    val S = times(H) { nextCharArray() }
    var ans = 0
    for (u in 0 until H) {
        for (d in u until H) {
            for (l in 0 until W) {
                for (r in l until W) {
                    var ok = true
                    for (i in u..d) {
                        for (j in l..r) {
                            if (S[i][j] != S[u + d - i][l + r - j]) ok = false
                        }
                    }
                    if (ok) ans++
                }
            }
        }
    }
    println(ans)
}
