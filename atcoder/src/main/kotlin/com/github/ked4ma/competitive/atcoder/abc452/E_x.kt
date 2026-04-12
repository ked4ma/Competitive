package com.github.ked4ma.competitive.atcoder.abc452

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.mod.*
import com.github.ked4ma.competitive.common.models.number.mod.long.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    MOD = MOD998244353
    val (N, M) = nextIntList().map { it + 1 }
    val A = listOf(0L) + nextLongList()
    val B = listOf(0L) + nextLongList()
    val s = sizedArray(N + 1, 0.toModLong())
    for (i in 0 until N) s[i + 1] += s[i] + A[i]

    var ans = 0.toModLong()
    run {
        var sa = 0.toModLong()
        var sb = 0.toModLong()
        for (i in 0 until N) sa += A[i] * i
        for (i in 0 until M) sb += B[i]
        ans += sa * sb
    }
    run {
        for (j in 1 until M) {
            for (l in 0 until N step j) {
                val r = min(N, l + j)
                ans -= (s[r] - s[l]) * l * B[j]
            }
        }
    }
    println(ans.toLong())
}
