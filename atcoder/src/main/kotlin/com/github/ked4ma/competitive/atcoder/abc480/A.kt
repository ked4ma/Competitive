package com.github.ked4ma.competitive.atcoder.abc480

import com.github.ked4ma.competitive.common.boolean.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = times(2) {
        next()
    }
    val ans = (!(
            (S[0][0] == 'A' && S[1][1] == 'D') ||
                    (S[0][0] == 'D' && S[1][1] == 'A') ||
                    (S[0][1] == 'A' && S[1][0] == 'D') ||
                    (S[0][1] == 'D' && S[1][0] == 'A')
            )).toYesNo()
    println(ans)
}
