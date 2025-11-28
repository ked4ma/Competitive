package com.github.ked4ma.competitive.codeforces.`2170`

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    val (n, k) = nextLongList().let { (n, k) -> n.toInt() to k }
    val Q = nextLongList().sortedDescending()
    val R = nextLongList().sorted()
    var ans = 0
    var ri = 0
    for (q in Q) {
        val r = R[ri]
        if (q * r + q + r <= k) {
            ri++
            ans++
        }
    }
    println(ans)
}
