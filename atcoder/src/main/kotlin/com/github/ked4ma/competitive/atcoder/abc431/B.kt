package com.github.ked4ma.competitive.atcoder.abc431

import com.github.ked4ma.competitive.common.array.boolean.d1.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    var X = nextInt()
    val N = nextInt()
    val A = nextIntList()
    val arr = sizedBooleanArray(N)
    val Q = nextInt()
    repeat(Q) {
        val P = nextInt() - 1
        X += if (arr[P]) -A[P] else A[P]
        arr[P] = !arr[P]
        println(X)
    }
}
