package com.github.ked4ma.competitive.atcoder.abc459

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val S = nextList()

    fun f(c: Char) = when (c) {
        'a', 'b', 'c' -> 2
        'd', 'e', 'f' -> 3
        'g', 'h', 'i' -> 4
        'j', 'k', 'l' -> 5
        'm', 'n', 'o' -> 6
        'p', 'q', 'r', 's' -> 7
        't', 'u', 'v' -> 8
        'w', 'x', 'y', 'z' -> 9
        else -> -1
    }

    var ans = 0L
    for (i in 0 until N) {
        ans = ans * 10 + f(S[i][0])
    }
    println(ans)
}
