package com.github.ked4ma.competitive.atcoder.abc443

import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.max
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    val N = nextInt()
    val R = nextIntList()
    val arr = R.toIntArray()
    for (i in 1 until N) {
        arr[i] = min(arr[i], arr[i - 1] + 1)
    }
    for (i in (0 until N - 1).reversed()) {
        arr[i] = min(arr[i], arr[i + 1] + 1)
    }
    var ans = 0L
    for (i in 0 until N) {
        ans += max(R[i] - arr[i], 0)
    }
    println(ans)
}
