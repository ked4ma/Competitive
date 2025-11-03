package com.github.ked4ma.competitive.atcoder.abc409

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.range.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, L) = nextIntList()
    val D = nextIntList()
    if (L % 3 != 0) {
        println(0)
        return
    }

    val arr = sizedLongArray(L, 0)
    arr[0] = 1
    run {
        var x = 0
        for (d in D) {
            x += d
            x %= L
            arr[x]++
        }
    }
    _debug_println(arr)
    var ans = 0L
    val l = L / 3
    for (i in range(l)) {
        ans += arr[i] * arr[i + l] * arr[i + l + l]
    }
    println(ans)
}
