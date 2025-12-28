package com.github.ked4ma.competitive.codeforces.`2178`

import com.github.ked4ma.competitive.common.input.default.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    val s = next()
    val stack = Stack<Char>()
    for (c in s) {
        if (stack.isEmpty()) {
            stack.push(c)
            continue
        }
        if (c == 'N') continue
        if (c == 'Y') {
            if (stack.peek() == 'N') {
                stack.pop()
            }
            stack.push(c)
        }
    }
    println(if (stack.size == 1) "YES" else "NO")
}
