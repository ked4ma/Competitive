package com.github.ked4ma.competitive.atcoder.awc0181

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.tree.fenwick.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val arr = sizedIntArray(N + 1)
    val LR = times(M) {
        val (L, R) = nextIntList()
        arr[L - 1]++
        arr[R]--
        L - 1 to R
    }
    var n = 0L
    val ft = FenwickTree(N)
    for (i in 0 until N) {
        if (arr[i] > 0) n++
        if (arr[i] == 1) ft.add(i, 1)
        arr[i + 1] += arr[i]
    }
    var ans = 0L
    for ((l, r) in LR) {
        ans = max(ans, n - ft.sum(l, r))
    }
    println(ans)
}
