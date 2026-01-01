package com.github.ked4ma.competitive.codeforces.`2182`

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    val n = nextInt()
    val a = nextIntList()
    val b = nextIntList()
    val c = nextIntList()
    fun count(x: List<Int>, y: List<Int>): Long {
        var res = 0L
        for (j in 0 until n) {
            var ok = true
            for (i in 0 until n) {
                if (x[i] >= y[(i + j) % n]) ok = false
            }
            if (ok) res++
        }
        return res
    }
    println(n.toLong() * count(a, b) * count(b, c))
}
