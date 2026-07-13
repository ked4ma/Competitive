package com.github.ked4ma.competitive.atcoder.arc224

import com.github.ked4ma.competitive.common.input.default.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    val S = nextCharArray()
    val n = S.size
    val stack = Stack<Char>()
    for (i in (0 until n).reversed()) {
        stack.push(S[i])
        for (c in 'A'..'C') {
            if (stack.isNotEmpty() && stack.peek() == c) {
                stack.pop()
            } else {
                break
            }
        }
    }
    println(stack.size)
}
