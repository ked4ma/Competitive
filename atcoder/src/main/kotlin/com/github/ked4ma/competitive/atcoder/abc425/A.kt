package com.github.ked4ma.competitive.atcoder.abc425

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.int.pow.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    var ans = 0
    for (i in 1..N) {
        ans += (-1).pow(i) * i.pow(3)
    }
    println(ans)
}
