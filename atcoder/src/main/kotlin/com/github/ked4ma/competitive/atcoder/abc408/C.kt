package com.github.ked4ma.competitive.atcoder.abc408

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import com.github.ked4ma.competitive.common.repeat.range.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val arr = sizedIntArray(N + 1, 0)
    repeat(M) {
        var (L, R) = nextIntList()
        L--
        arr[L]++
        arr[R]--
    }
    for (i in 1..N) {
        arr[i] += arr[i - 1]
    }
    var ans = INT_INF
    for (i in range(N)) {
        ans = min(ans, arr[i])
    }
    _debug_println(arr)
    println(ans)
}
