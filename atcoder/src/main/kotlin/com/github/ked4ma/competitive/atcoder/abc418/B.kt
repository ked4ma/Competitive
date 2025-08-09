package com.github.ked4ma.competitive.atcoder.abc418

import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = nextCharArray()
    val N = S.size
    var ans = 0.0
    for (i in 0 until N) {
        for (j in i + 2 until N) {
            if (S[i] != 't' || S[j] != 't') continue
            var cnt = 0
            for (k in i + 1 until j) {
                if (S[k] == 't') cnt++
            }
            ans = max(ans, cnt.toDouble() / (j - i - 1))
        }
    }
    println(ans)
}
