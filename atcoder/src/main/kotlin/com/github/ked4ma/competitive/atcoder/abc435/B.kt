package com.github.ked4ma.competitive.atcoder.abc435

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.long.cumlative.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextLongList()
    val cum = A.cumulativeSum()
    var ans = 0
    for (l in 0 until N) {
        for (r in l + 1..N) {
            val sum = cum[r] - cum[l]
            if ((l until r).all { sum % A[it] != 0L }) {
                ans++
            }
        }
    }
    println(ans)
}
