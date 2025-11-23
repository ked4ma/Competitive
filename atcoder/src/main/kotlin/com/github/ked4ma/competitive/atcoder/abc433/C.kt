package com.github.ked4ma.competitive.atcoder.abc433

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = nextCharArray()
    var ans = 0
    var pre = -1 to 0
    var i = 0
    while (i < S.size) {
        val n = S[i] - '0'
        var cnt = 1
        while (i + 1 < S.size && S[i + 1] - '0' == n) {
            cnt++
            i++
        }
        _debug_println(n to cnt)

        if (pre.first + 1 == n) {
            ans += min(pre.second, cnt)
        }

        pre = n to cnt

        i++
    }
    println(ans)
}
