package com.github.ked4ma.competitive.atcoder.abc409

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList()
    val cnt = sizedIntArray(102, 0)
    for (a in A) {
        cnt[min(101, a)]++
    }
    var sum = 0
    for (i in 101 downTo 0) {
        sum += cnt[i]
        if (sum >= i) {
            println(i)
            return
        }
    }
}
