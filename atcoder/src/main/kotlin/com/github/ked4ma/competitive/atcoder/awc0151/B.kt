package com.github.ked4ma.competitive.atcoder.awc0151

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.debug._debug_println
import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val P = nextIntList()

    var max = 0
    val arr = sizedIntArray(N + 1)
    var ans = 0
    repeat(M) { i ->
        arr[P[i]]++
        if (P[i] == 2) {
            if (arr[P[i]] < max) ans++
        } else {
            max = max(max, arr[P[i]])
        }
        _debug_println(max)
    }
    println(ans)
}
