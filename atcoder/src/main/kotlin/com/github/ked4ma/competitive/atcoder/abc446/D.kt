package com.github.ked4ma.competitive.atcoder.abc446

import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList()
    val memo = mutableMapOf<Int, Int>().withDefault { -1 }
    var ans = 0
    for (i in 0 until N) {
        val a = A[i]
        if (memo.getValue(a - 1) == -1) {
            memo[a] = 1
        } else {
            memo[a] = memo.getValue(a - 1) + 1
        }
        ans = max(ans, memo.getValue(a))
    }
    println(ans)
}
