package com.github.ked4ma.competitive.atcoder.abc436

import com.github.ked4ma.competitive.common.array.int.d2.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val arr = sized2DIntArray(N, N, 0)
    var r = 0
    var c = (N - 1) / 2
    repeat(N * N) { k ->
        arr[r][c] = k + 1
        if (arr[(r - 1 + N) % N][(c + 1) % N] == 0) {
            r = (r - 1 + N) % N
            c = (c + 1) % N
        } else {
            r = (r + 1 + N) % N
        }
    }
    println(arr.joinToString("\n") { it.joinToString(" ") })
}
