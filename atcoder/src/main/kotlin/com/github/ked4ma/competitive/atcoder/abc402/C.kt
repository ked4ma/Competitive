package com.github.ked4ma.competitive.atcoder.abc402

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val KA = times(M) { nextIntList() }
    val B = nextIntList()
    val bi = sizedIntArray(N + 1, 0)
    for (i in range(N)) {
        val b = B[i]
        bi[b] = i
    }
    val ans = sizedIntArray(N, 0)
    for (ka in KA) {
        var t = 0
        for (i in 1..ka[0]) {
            t = max(t, bi[ka[i]])
        }
        ans[t]++
    }
    for (i in range(N - 1)) {
        ans[i + 1] += ans[i]
    }
    println(ans.joinToString("\n"))
}
