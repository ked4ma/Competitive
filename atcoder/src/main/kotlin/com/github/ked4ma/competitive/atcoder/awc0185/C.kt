package com.github.ked4ma.competitive.atcoder.awc0185

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextLongList().let { (N, K) -> N.toInt() to K }
    val A = nextLongList()
    var r = 0
    var n = 0L
    var ans = 0
    for (l in 0 until N) {
        while (r < N && n + A[r] <= K) {
            n += A[r]
            r++
        }
        if (n == K) ans++
        n -= A[l]
    }
    println(ans)
}
