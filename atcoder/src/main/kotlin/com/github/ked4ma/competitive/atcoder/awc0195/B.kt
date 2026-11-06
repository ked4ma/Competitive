package com.github.ked4ma.competitive.atcoder.awc0195

import com.github.ked4ma.competitive.common.array.char.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList()
    val ans = sizedCharArray(N, 'x')
    ans[0] = 'o'
    var x = A[0]
    for (i in 1 until N) {
        if (A[i] > x) {
            ans[i] = 'o'
        }
        x = max(x, A[i])
    }
    println(ans.concatToString())
}
