package com.github.ked4ma.competitive.atcoder.awc0200

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.array.int.output.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList()
    val ans = sizedIntArray(3)
    for (i in 1 until N) {
        val a = A[i] - A[i - 1]
        if (a > 0) {
            ans[0]++
        } else if (a < 0) {
            ans[1]++
        } else {
            ans[2]++
        }
    }
    ans.println(" ")
}
