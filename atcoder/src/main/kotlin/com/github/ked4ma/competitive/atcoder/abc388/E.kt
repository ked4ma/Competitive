package com.github.ked4ma.competitive.atcoder.abc388

import com.github.ked4ma.competitive.common.array.boolean.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.range.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList()
    val used = sizedBooleanArray(N)
    var j = N / 2
    var ans = 0
    for (i in range(N)) {
        if (used[i]) continue
        while (j < N && (used[j] || A[i] * 2 > A[j])) j++
        if (j < N) {
            used[i] = true
            used[j] = true
            ans++
        }
    }
    println(ans)
}
