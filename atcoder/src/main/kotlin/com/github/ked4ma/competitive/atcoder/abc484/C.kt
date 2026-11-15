package com.github.ked4ma.competitive.atcoder.abc484

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList()
    val B = nextIntList()
    var l = 0
    while (l < N && A[l] == B[l]) l++
    var r = N
    while (r > 0 && A[r - 1] == B[r - 1]) r--
    _debug_println("$l $r")
    _debug_println(l < r) { A.slice(l until r) }
    _debug_println(l < r) { B.slice(l until r) }

    if (l < r) {
        val A2 = A.slice(l until r)
        val B2 = B.slice(l until r)
        _debug_println("----")
        _debug_println(A2.slice(1 until A2.size) + listOf(A2.first()))
        _debug_println(A2.slice(0 until A2.size - 1) + listOf(A2.last()))
        if (A2.slice(1 until A2.size) + listOf(A2.first()) == B2 ||
            listOf(A2.last()) + A2.slice(0 until A2.size - 1) == B2
        ) {
            println("Yes")
        } else {
            println("No")
        }
    } else {
        println("Yes")
    }
}
