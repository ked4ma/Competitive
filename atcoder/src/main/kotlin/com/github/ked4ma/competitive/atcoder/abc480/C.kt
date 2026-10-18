package com.github.ked4ma.competitive.atcoder.abc480

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.div.ceil.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K, T) = nextIntList()
    val A = nextIntList().filter { it <= T }.sorted()
    val n = A.size
    var t = 0
    var ans = 0
    var i = 0
    while (i < n) {
        while (i < n && A[i] < t) {
            t = max(t, A[i] + K)
            i++
        }
        if (i == n) break
        val j = A[i] - t
        ans += j.ceilDiv(K)
        t = max(t, A[i] + K)
        i++
        _debug_println(ans)
    }
    if (t < T) ans += (T - t).ceilDiv(K)
    println(ans)
}
