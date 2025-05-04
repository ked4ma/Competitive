package com.github.ked4ma.competitive.atcoder.abc404

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.array.int.d2.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.base3.*
import com.github.ked4ma.competitive.common.number.inf.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val C = nextLongList()
    val A = sized2DIntArray(N, M, 0)
    repeat(M) { i ->
        val data = nextIntList()
        for (j in 1..data[0]) {
            A[data[j] - 1][i]++
        }
    }
    _debug_println(A)
    var ans = LONG_INF
    // for (i in range(1 shl (2 * N))) {
    //     var cost = 0L
    //     val cnt = sizedIntArray(M, 0)
    //     for (j in range(2 * N)) {
    //         if (!i.bit(j)) continue
    //         for (k in range(M)) {
    //             cnt[k] += A[j / 2][k]
    //         }
    //         cost += C[j / 2]
    //     }
    //     if (cnt.all { it >= 2 }) {
    //         ans = min(ans, cost)
    //     }
    // }
    Base3(N).forEach { t ->
        var cost = 0L
        val cnt = sizedIntArray(M, 0)
        for (i in range(N)) {
            cost += C[i] * t[i]
            for (j in range(M)) {
                cnt[j] += A[i][j] * t[i]
            }
        }
        if (cnt.any { it < 2 }) cost = LONG_INF
        ans = min(ans, cost)
    }
    println(ans)
}
