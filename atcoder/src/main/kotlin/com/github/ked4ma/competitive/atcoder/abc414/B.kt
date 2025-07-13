package com.github.ked4ma.competitive.atcoder.abc414

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val sb = StringBuilder(100)
    for (i in range(N)) {
        val (c, l) = nextList().let { (c, l) -> c to l.toLong() }
        for (j in 0 until l) {
            sb.append(c)
            if (sb.length > 100) {
                println("Too Long")
                return
            }
        }
    }
    println(sb)
}
