package com.github.ked4ma.competitive.atcoder.awc0192

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.array.int.output.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextIntList()
    val AB = times(N) {
        val (A, B) = nextIntList()
        it to A + B
    }.sortedWith(compareBy({ -it.second }, { it.first }))
    val ans = sizedIntArray(N, -1)
    for (j in 0 until N) {
        val (i, k) = AB[j]
        ans[i] = if (k >= K) j + 1 else -1
    }
    ans.println("\n")
}
