package com.github.ked4ma.competitive.atcoder.abc474_na

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.array.long.output.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextLongList()
    val B = nextLongList()
    if ((0 until N).all { A[it] <= B[it] }) {
        println("No")
        return
    }
    var i = -1
    var max = -LONG_INF
    var sum = 0L
    for (j in 0 until N) {
        if (A[j] - B[j] > max) {
            i = j
            max = A[j] - B[j]
        }
        sum += A[j] - B[j]
    }
    val ans = sizedLongArray(N, 1)
    ans[i] = 1_000_000_000_000_000_000L
    println("Yes")
    ans.println(" ")
}
