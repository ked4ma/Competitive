package com.github.ked4ma.competitive.atcoder.abc403

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M, Q) = nextIntList()
    val data = sizedArray(N + 1) { mutableSetOf<Int>() }
    repeat(Q) {
        val q = nextIntList()
        when (q[0]) {
            1 -> {
                val x = q[1]
                val y = q[2]
                data[x].add(y)
            }

            2 -> {
                val x = q[1]
                data[x].add(0)
            }

            3 -> {
                val x = q[1]
                val y = q[2]
                println(if (0 in data[x] || y in data[x]) "Yes" else "No")
            }
        }
    }
}
