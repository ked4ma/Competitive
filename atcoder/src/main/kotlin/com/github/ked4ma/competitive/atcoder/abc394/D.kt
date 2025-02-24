package com.github.ked4ma.competitive.atcoder.abc394

import com.github.ked4ma.competitive.common.input.default.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = nextCharArray()

    val q = Stack<Char>()
    for (c in S) {
        if (q.isEmpty()) {
            q.push(c)
            continue
        }
        if (c in listOf('(', '[', '<')) {
            q.push(c)
            continue
        }
        val c2 = when (c) {
            ')' -> '('
            ']' -> '['
            '>' -> '<'
            else -> throw RuntimeException()
        }
        if (q.peek() == c2) {
            q.pop()
        } else {
            q.push(c)
        }
    }

    println(if (q.isEmpty()) "Yes" else "No")
}
