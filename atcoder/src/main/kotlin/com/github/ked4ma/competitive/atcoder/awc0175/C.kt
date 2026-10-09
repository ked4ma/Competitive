package com.github.ked4ma.competitive.atcoder.awc0175

import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.max
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val H = nextLongList()
    var ans = 0L
    for (i in 2 until N) {
        ans += max(0, min(H[i - 2] - H[i - 1], H[i] - H[i - 1]))
    }
    println(ans)
}
