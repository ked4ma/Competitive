package com.github.ked4ma.competitive.atcoder.abc402

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val arr = sizedLongArray(2 * N, 0)
    repeat(M) {
        val (A, B) = nextIntList()
        var x = ((B - A) + 2 * A)
        if (x > N) x = (x + N) % (2 * N)
        arr[x]++
    }
    var ans = M.toLong() * (M - 1) / 2
    for (n in arr) {
        if (n > 1) {
            ans -= n * (n - 1) / 2
        }
    }
    println(ans)
}
