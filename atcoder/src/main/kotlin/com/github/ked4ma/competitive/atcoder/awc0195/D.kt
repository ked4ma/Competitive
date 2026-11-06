package com.github.ked4ma.competitive.atcoder.awc0195

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val C = nextIntList().map { it - 1 }

    val cnt = sizedIntArray(7)
    var a = 0
    var r = 0
    var ans = 0L
    for (l in 0 until N) {
        while (r < N && a < 7) {
            cnt[C[r]]++
            if (cnt[C[r]] == 1) a++
            r++
        }

        if (a == 7) {
            ans += N - r + 1
        }

        cnt[C[l]]--
        if (cnt[C[l]] == 0) a--
    }
    println(ans)
}
