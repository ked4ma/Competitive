package com.github.ked4ma.competitive.codeforces.`2198`

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*

fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    val n = nextInt()
    val A = nextIntList()
    val arr = sizedIntArray(n + 1)
    var ans = 0
    for (a in A) {
        arr[a]++
        if (arr[a] % 2 == 0) ans++
    }
    println(ans)
}
