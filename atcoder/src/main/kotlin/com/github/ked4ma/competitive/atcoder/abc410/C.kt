package com.github.ked4ma.competitive.atcoder.abc410

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val A = sizedIntArray(N) { i -> i + 1 }
    var k = 0
    val ans = mutableListOf<Int>()
    repeat(Q) {
        val query = nextIntList()
        when (query[0]) {
            1 -> {
                val p = query[1]
                val x = query[2]
                A[(p - 1 + k) % N] = x
            }

            2 -> {
                val p = query[1]
                ans.add(A[(p - 1 + k) % N])
            }

            3 -> {
                k = (k + query[1]) % N
            }
        }
    }
    println(ans.joinToString("\n"))
}
