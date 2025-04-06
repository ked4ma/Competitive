package com.github.ked4ma.competitive.codeforces.`2088`

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val n = nextInt()
    if (n == 1) {
        println("Yes")
        return
    }
    val S = nextCharArray()
    val arr = sizedIntArray(26, 0)
    for (c in S) {
        arr[c - 'a']++
    }
    println(if (arr.any { it >= 2 }) "Yes" else "No")
}
