package com.github.ked4ma.competitive.atcoder.abc483

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val stack = Stack<Int>()
    for (i in N downTo 1) {
        stack.push(i)
    }
    _debug_println(stack.toList())

    val K = nextIntList()
    val q = ArrayDeque<Int>()
    for (k in K) {
        repeat(k) {
            q.add(-stack.pop())
        }
        repeat(k) {
            stack.push(q.removeFirst())
        }
        _debug_println(stack.toList())
    }
    repeat(N) {
        println(stack.pop())
    }
}
