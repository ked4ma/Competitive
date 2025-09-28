package com.github.ked4ma.competitive.atcoder.abc425

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList().toIntArray()
    val p = (1..N).toMutableSet()
    for (a in A) {
        if (a == -1) continue
        if (a !in p) {
            println("No")
            return
        }
        p.remove(a)
    }
    val queue = ArrayDeque<Int>()
    queue.addAll(p)
    for (i in 0 until N) {
        if (A[i] == -1) {
            A[i] = queue.removeFirst()
        }
    }
    println("Yes")
    println(A.joinToString(" "))
}
