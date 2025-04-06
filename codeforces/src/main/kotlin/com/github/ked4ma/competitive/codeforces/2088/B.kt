package com.github.ked4ma.competitive.codeforces.`2088`

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        val n = nextInt()
        val cnt = sizedIntArray(2, 0)
        for (c in next()) {
            if (c == '-') cnt[0]++
            else if (c == '_') cnt[1]++
        }
        val a = cnt[0] / 2L
        val b = cnt[1]
        val c = cnt[0] - a
        println(a * b * c)
    }
}
