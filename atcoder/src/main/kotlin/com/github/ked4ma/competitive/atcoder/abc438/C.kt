package com.github.ked4ma.competitive.atcoder.abc438

import com.github.ked4ma.competitive.common.input.default.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList()
    val stack = Stack<Pair<Int, Int>>()
    for (a in A) {
        if (stack.isEmpty() || stack.peek().first != a) {
            stack.push(a to 1)
            continue
        }
        val n = stack.pop().second + 1
        if (n == 4) continue
        stack.push(a to n)
    }
    var ans = 0
    for ((_, n) in stack) {
        ans += n
    }
    println(ans)
}
