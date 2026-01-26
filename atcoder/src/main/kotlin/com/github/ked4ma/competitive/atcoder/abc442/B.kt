package com.github.ked4ma.competitive.atcoder.abc442

import com.github.ked4ma.competitive.common.boolean.*
import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    var v = 0
    var p = false

    val Q = nextInt()
    repeat(Q) {
        val A = nextInt()
        when (A) {
            1 -> {
                v++
            }

            2 -> {
                v = max(0, v - 1)
            }

            3 -> {
                p = !p
            }
        }
        println((v >= 3 && p).toYesNo())
    }
}
