package com.github.ked4ma.competitive.atcoder.abc484

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.set.multi.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList()

    val set = MultiSet<Int>()
    var ans = 1L
    for (i in 0 until N) {
        if (i == 0 || A[i - 1] != A[i]) {
            ans += (i - set.count(A[i]))
        }
        set.add(A[i])
    }
    println(ans)
}
