package com.github.ked4ma.competitive.atcoder.abc473

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList()
    val set = mutableSetOf<Int>()
    for (a in A) {
        if (a in set) {
            set.remove(a)
        } else {
            set.add(a)
        }
    }
    println(set.sum())
}
