package com.github.ked4ma.competitive.atcoder.abc399

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val P = nextIntList()
    var r = 1
    val ans = sizedIntArray(N, -1)
    for ((v, x) in P.withIndex().groupBy{ it.value }.toSortedMap(compareByDescending { it })) {
        for ((i , _) in x) {
            ans[i] = r
        }
        r += x.size
    }
    println(ans.joinToString("\n"))
}
