package com.github.ked4ma.competitive.codeforces.`2198`

import com.github.ked4ma.competitive.common.array.char.d1.*
import com.github.ked4ma.competitive.common.input.default.*

fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    val (n, m, k) = nextIntList()
    val a = nextIntList()
    val q = nextIntList()
    if (n == k) {
        println("1".repeat(m))
        return
    }
    if (n - k > 1) {
        println("0".repeat(m))
        return
    }
    val unk = run {
        for (j in 0 until n - 1) {
            if (j + 1 != q[j]) return@run j + 1
        }
        return@run n
    }
    val ans = sizedCharArray(m, '0')
    for (i in 0 until m) {
        if (a[i] == unk) ans[i] = '1'
    }
    println(ans.concatToString())
}
