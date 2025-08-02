package com.github.ked4ma.competitive.atcoder.abc416

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    val (N, M) = nextLongList().let { (N, M) -> N.toInt() to M }
    val A = nextLongList().sortedDescending()
    val B = nextLongList().sorted()
    var bi = 0
    var ans = 0L
    for (a in A) {
        while (bi < N && a + B[bi] < M) {
            ans += B[bi]
            bi++
        }
        if (bi < N) {
            ans += (a + B[bi]) % M
            bi++
        } else {
            ans += a
        }
    }
    println(ans)
}
