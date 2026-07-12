package com.github.ked4ma.competitive.atcoder.abc466

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val rcArr = sizedIntArray(N, -1)
    val crArr = sizedIntArray(N, -1)
    repeat(M) {
        val (r, c) = nextIntList().map { it - 1 }
        val pc = rcArr[r]
        val pr = crArr[c]
        if (pc != -1) crArr[pc] = -1
        if (pr != -1) rcArr[pr] = -1
        rcArr[r] = c
        crArr[c] = r
    }
    println(rcArr.count { it >= 0 })
}
