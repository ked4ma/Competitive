package com.github.ked4ma.competitive.atcoder.abc454

import com.github.ked4ma.competitive.common.boolean.*
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
    val A = next()
    val B = next()
    println((minimize(A) == minimize(B)).toYesNo())
}

private fun minimize(s: String): String {
    val stack = Stack<Char>()
    var xCnt = 0
    for (c in s) {
        when (c) {
            '(' -> {
                repeat(xCnt) { stack.push('x') }
                xCnt = 0
                stack.push(c)
            }

            'x' -> {
                xCnt++
            }

            ')' -> {
                if (xCnt == 2 && stack.isNotEmpty() && stack.peek() == '(') {
                    stack.pop()
                } else {
                    repeat(xCnt) { stack.push('x') }
                    xCnt = 0
                    stack.push(c)
                }
            }
        }
    }
    repeat(xCnt) { stack.push('x') }
    return stack.toCharArray().reversedArray().concatToString()
}
