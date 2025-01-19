package com.github.ked4ma.competitive.atcoder.abc389

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val Q = nextInt()
    val cum = mutableListOf<Long>(0)
    var leftCount = 0
    repeat(Q) {
        val input = nextIntList()
        when (input[0]) {
            1 -> {
                cum.add(cum.last() + input[1])
            }

            2 -> {
                leftCount++
            }

            3 -> {
                val k = input[1] - 1 + leftCount
                println(cum[k] - cum[leftCount])
            }
        }
    }
}
