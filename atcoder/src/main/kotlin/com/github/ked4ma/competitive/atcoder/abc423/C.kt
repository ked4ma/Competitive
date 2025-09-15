package com.github.ked4ma.competitive.atcoder.abc423

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, R) = nextIntList()
    val L = nextIntList()
    var left = L.slice(0 until R)
    var right = L.slice(R until N).asReversed()
    _debug_println(left)
    _debug_println(right)
    val li = left.indexOfFirst { it == 0 }
    left = if (li >= 0) {
        (left.slice(li until left.size))
    } else {
        listOf()
    }
    val ri = right.indexOfFirst { it == 0 }
    right = if (ri >= 0) {
        (right.slice(ri until right.size))
    } else {
        listOf()
    }
    println(left.sum() + right.sum() + left.size + right.size)
}
