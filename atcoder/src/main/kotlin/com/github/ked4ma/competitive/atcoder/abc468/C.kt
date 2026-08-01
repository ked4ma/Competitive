package com.github.ked4ma.competitive.atcoder.abc468

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.array.permutation.int.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val P = nextIntList().fold(0L) { acc, i -> acc * 10 + i }
    val Q = nextIntList().fold(0L) { acc, i -> acc * 10 + i }
    _debug_println("$P $Q")
    val arr = sizedIntArray(N) { it + 1 }
    var ans = 0
    while (true) {
        val n = arr.fold(0L) { acc, i -> acc * 10 + i }
        if (P < n && n < Q) ans++
        if (!arr.nextPermutation()) break
    }
    println(ans)
}
