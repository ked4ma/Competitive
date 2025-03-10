package com.github.ked4ma.competitive.atcoder.abc396

import com.github.ked4ma.competitive.common.input.default.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val Q = nextInt()
    val stack = Stack<Int>()
    repeat(100) {
        stack.push(0)
    }
    repeat(Q) {
        val data = nextIntList()
        when (data[0]) {
            1 -> {
                stack.push(data[1])
            }

            2 -> {
                println(stack.pop())
            }
        }
    }
}
