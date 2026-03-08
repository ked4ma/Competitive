package com.github.ked4ma.competitive.atcoder.abc448

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.debug._debug_println
import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val C = nextIntList()
    val arr = sizedIntArray(M)
    repeat(N) {
        val (a, b) = nextIntList()
        arr[a - 1] += b
    }
    var ans = 0
    for (i in 0 until M) {
        ans += min(arr[i], C[i])
    }
    println(ans)
}
