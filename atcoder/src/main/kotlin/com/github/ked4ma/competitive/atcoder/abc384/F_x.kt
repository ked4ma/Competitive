package com.github.ked4ma.competitive.atcoder.abc384

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.long.pow.*
import com.github.ked4ma.competitive.common.repeat.range.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextLongList()
    A.forEach { _debug_println(it.toString(2)) }

    val d = sizedLongArray(29, 0)
    for (k in range(29)) {
        val kk = 2L.pow(k)
        val map = mutableMapOf<Long, Pair<Long, Long>>()
        for (a in A) {
            map.compute((-a).mod(kk)) { _, v -> ((v ?: (0L to 0L))).let { (c, s) -> c + 1 to s + a } }
            // 1 <= i <= j <= N
            // loop1: (j = 1)
            // loop2: loop1 + (j = 2)
            // loop3: loop2 + (j = 3)
            d[k] += map.getOrDefault(a.mod(kk), 0L to 0L).let { (c, s) -> c * a + s }
        }
    }
    _debug_println(d.joinToString(","))
    var ans = 0L
    var kk = 1L
    for (k in range(28)) {
        ans += (d[k] - d[k + 1]) / kk
        kk *= 2
    }
    println(ans)
}
