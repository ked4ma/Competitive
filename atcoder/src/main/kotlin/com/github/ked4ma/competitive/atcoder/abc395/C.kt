package com.github.ked4ma.competitive.atcoder.abc395

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.range.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList()
    val map = mutableMapOf<Int, Int>()
    var ans = Int.MAX_VALUE
    for (i in range(N)) {
        val a = A[i]
        if (a in map) {
            ans = min(ans, i - map.getValue(a) + 1)
        } else {
            map[a] = i
        }
    }
    println(if (ans == Int.MAX_VALUE) -1 else ans)
}
