package com.github.ked4ma.competitive.atcoder.abc446

import com.github.ked4ma.competitive.common.array.boolean.d1.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val used = sizedBooleanArray(M + 1)
    repeat(N) {
        val L = nextInt()
        val X = nextIntList()
        for (x in X) {
            if (used[x]) continue
            used[x] = true
            println(x)
            return@repeat
        }
        println(0)
    }
}
