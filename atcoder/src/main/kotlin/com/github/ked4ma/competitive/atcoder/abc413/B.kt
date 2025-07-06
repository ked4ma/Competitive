package com.github.ked4ma.competitive.atcoder.abc413

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val S = times(N) { next() }
    val set = mutableSetOf<String>()
    for (i in range(N)) {
        for (j in i + 1 until N) {
            set.add(S[i] + S[j])
            set.add(S[j] + S[i])
        }
    }
    println(set.size)
}
