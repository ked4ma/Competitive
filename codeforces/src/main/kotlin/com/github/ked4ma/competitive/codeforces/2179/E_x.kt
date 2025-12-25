package com.github.ked4ma.competitive.codeforces.`2179`

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.debug._debug_println
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    var (n, x, y) = nextLongList().let { (n, x, y) -> Triple(n.toInt(), x, y) }
    val s = nextCharArray()
    val p = nextLongList()
    if (x + y < p.sum()) {
        println("NO")
        return
    }
    if (s.toSet().size == 1) {
        if (s[0] == '1') {
            x = y.also { y = x }
        }
        var need = 0L
        for (i in 0 until n) {
            need += p[i] / 2 + 1
        }
        _debug_println("$n $x $y $need")
        println(if (x < need || x < y + n) "NO" else "YES")
        return
    }
    val needs = sizedLongArray(2)
    for (i in 0 until n) {
        val c = s[i] - '0'
        needs[c] += p[i] / 2 + 1
    }
    println(if (x >= needs[0] && y >= needs[1]) "YES" else "NO")
}
