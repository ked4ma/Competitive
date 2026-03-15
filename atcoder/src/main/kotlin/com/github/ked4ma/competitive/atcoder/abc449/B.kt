package com.github.ked4ma.competitive.atcoder.abc449

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W, Q) = nextIntList()
    var R = H
    var C = W
    repeat(Q) {
        val query = nextIntList()
        when (query[0]) {
            1 -> {
                val r = query[1]
                println(r * C)
                R -= r
            }

            2 -> {
                val c = query[1]
                println(R * c)
                C -= c
            }
        }
    }
}
