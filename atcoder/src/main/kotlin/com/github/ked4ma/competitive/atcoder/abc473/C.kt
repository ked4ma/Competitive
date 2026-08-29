package com.github.ked4ma.competitive.atcoder.abc473

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextIntList()
    val A = nextIntList()
    val cls = sizedIntArray(K)
    for (a in A) {
        cls[a - 1]++
    }
    val b = cls.sortedDescending()
    val max = b[0]
    _debug_println(b)
    var i = 0
    while (i < K && b[i] + 1 >= max) i++
    println(i)
}
