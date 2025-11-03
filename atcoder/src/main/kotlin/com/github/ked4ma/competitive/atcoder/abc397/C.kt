package com.github.ked4ma.competitive.atcoder.abc397

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.array.int.d2.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.range.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList()
    val cnt = sized2DIntArray(2, N + 1, 0)
    val tArr = sizedIntArray(2, 0)
    for (i in range(N)) {
        if (++cnt[1][A[i]] == 1) tArr[1]++
    }

    var ans = 0
    for (i in range(N - 1)) {
        if (--cnt[1][A[i]] == 0) tArr[1]--
        if (++cnt[0][A[i]] == 1) tArr[0]++
        ans = max(ans, tArr[0] + tArr[1])
    }
    println(ans)
}
