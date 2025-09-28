package com.github.ked4ma.competitive.atcoder.abc425

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.long.cumlative.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val A = nextLongList()
    val A2Cum = (A + A).cumulativeSum()
    var i = 0
    repeat(Q) {
        val query = nextIntList()
        when (query[0]) {
            1 -> {
                val c = query[1]
                i = (i + c) % N
            }

            2 -> {
                val l = query[1] - 1
                val r = query[2]
                println(A2Cum[r + i] - A2Cum[l + i])
            }
        }
    }
}
