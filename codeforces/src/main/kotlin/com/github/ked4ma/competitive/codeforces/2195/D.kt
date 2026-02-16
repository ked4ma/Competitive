package com.github.ked4ma.competitive.codeforces.`2195`

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.long.output.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    val n = nextInt()
    val fx = nextLongList()
    val base = (fx[0] + fx[n - 1]) / (n - 1)
    _debug_println(base)
    var l = 0
    var lv = fx[n - 1]
    var r = n - 1
    var rv = fx[0]
    val arr = sizedLongArray(n)
    while (l < r) {
        val m = n - 2 - l
        _debug_println("m=$m")
        val nlv = base * m - fx[l + 1]
        val nrv = base * m - fx[r - 1]
        arr[l] = lv - nlv
        arr[r] = rv - nrv
        lv = nlv
        rv = nrv
        l++
        r--
    }
    for (i in (1 until n / 2).reversed()) {
        arr[i] -= arr[i - 1]
        arr[n - 1 - i] -= arr[n - 1 - i + 1]
    }
    if (l == r) {
        arr[l] = base * 2 - arr.sum()
    }
    arr.map { it / 2 }.println(" ")
}
