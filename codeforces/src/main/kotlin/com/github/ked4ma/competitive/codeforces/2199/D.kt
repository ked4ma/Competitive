package com.github.ked4ma.competitive.codeforces.`2199`

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    val (n, m) = nextIntList()
    val a = nextIntList()
    val b = nextIntList()
    val (al, ar) = if (n == 1) {
        0 to 1
    } else {
        1 to n - 1
    }
    val (bl, br) = if (m == 1) {
        0 to 1
    } else {
        1 to m - 1
    }
    var i = al
    var j = bl
    while (i < ar && j < br) {
        if (a[i] == b[j]) break
        if (a[i] > b[j]) {
            j++
        } else {
            i++
        }
    }
    println(if (i in al until ar && j in bl until br) "YES" else "NO")
}
