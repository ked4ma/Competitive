package com.github.ked4ma.competitive.codeforces.`2171`

import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.abs

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    val n = nextInt()
    val a = nextIntList().toIntArray()
    if (a[0] == -1 && a[n - 1] == -1) {
        a[0] = 0
        a[n - 1] = 0
    } else if (a[0] == -1) {
        a[0] = a[n - 1]
    } else if (a[n - 1] == -1) {
        a[n - 1] = a[0]
    }
    for (i in 1 until n - 1) {
        if (a[i] == -1) a[i] = 0
    }
    println(abs(a[0] - a[n - 1]))
    println(a.joinToString(" "))
}
