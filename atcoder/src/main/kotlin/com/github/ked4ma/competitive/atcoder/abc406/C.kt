package com.github.ked4ma.competitive.atcoder.abc406

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val P = nextIntList()
    val list = buildList {
        for (i in 1 until N - 1) {
            if (P[i - 1] < P[i] && P[i] > P[i + 1]) add(i to 1)
            if (P[i - 1] > P[i] && P[i] < P[i + 1]) add(i to -1)
        }
    }
    _debug_println(list)
    var ans = 0L
    for (i in range(list.size - 1)) {
        val (i1, t1) = list[i]
        val (i2, t2) = list[i + 1]
        if (!(t1 == 1 && t2 == -1)) continue
        val preI1 = if (i == 0) 0 else list[i - 1].first
        val posI2 = if (i + 1 == list.size - 1) N - 1 else list[i + 2].first
        _debug_println("$i1 $i2 $preI1 $posI2:  ${(i1 - preI1) * (posI2 - i2)}")
        ans += (i1 - preI1).toLong() * (posI2 - i2)
    }
    println(ans)
}
