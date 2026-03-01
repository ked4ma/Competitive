package com.github.ked4ma.competitive.codeforces.`2198`

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.max

fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    val (a1, a2, a4, a5) = nextIntList()
    val arr = sizedIntArray(5)
    arr[0] = a1
    arr[1] = a2
    arr[3] = a4
    arr[4] = a5
    var ans = 0
    arr[2] = a1 + a2
    ans = max(ans, check(arr))
    arr[2] = a4 - a2
    ans = max(ans, check(arr))
    arr[2] = a5 - a4
    ans = max(ans, check(arr))
    println(ans)
}

private fun check(arr: IntArray): Int {
    var cnt = 0
    for (i in 0 until 3) {
        if (arr[i] + arr[i + 1] == arr[i + 2]) cnt++
    }
    return cnt
}
