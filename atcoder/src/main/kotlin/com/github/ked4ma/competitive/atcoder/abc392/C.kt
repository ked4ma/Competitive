package com.github.ked4ma.competitive.atcoder.abc392

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val P = nextIntList()
    val Q = nextIntList()
    val Q2 = sizedIntArray(N, 0)
    for (i in range(N)) {
        Q2[Q[i] - 1] = i
    }
    _debug_println(Q2.joinToString(" "))
    val ans = sizedIntArray(N, 0)
    for (i in range(N)) {
        ans[i] = Q[P[Q2[i]] - 1]
    }
    println(ans.joinToString(" "))
}
