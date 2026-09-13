package com.github.ked4ma.competitive.atcoder.abc475

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.array.int.output.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList()
    val arr = sizedIntArray(3)
    for (a in A) {
        var b = (1000 - a % 1000) % 1000
        arr[2] += b / 100
        b %= 100
        arr[1] += b / 10
        b %= 10
        arr[0] += b
    }
    arr.println(" ")
}
