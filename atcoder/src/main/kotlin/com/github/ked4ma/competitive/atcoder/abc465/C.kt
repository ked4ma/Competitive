package com.github.ked4ma.competitive.atcoder.abc465

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val S = nextCharArray()

    var rev = false
    val q = ArrayDeque<Int>()
    for (i in 0 until N) {
        val c = S[i]
        if (rev) {
            q.addFirst(i + 1)
        } else {
            q.addLast(i + 1)
        }
        if (c == 'o') rev = !rev
    }
    println((if (rev) q.reversed() else q.toList()).joinToString(" "))
}
