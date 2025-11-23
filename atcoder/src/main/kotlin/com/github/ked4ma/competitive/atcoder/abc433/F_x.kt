package com.github.ked4ma.competitive.atcoder.abc433

import com.github.ked4ma.competitive.common.array.int.d2.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.combimation.mod.*
import com.github.ked4ma.competitive.common.math.mod.*
import com.github.ked4ma.competitive.common.models.number.mod.long.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val MOD = MOD998244353
    val S = nextCharArray()
    val N = S.size
    val cnt = sized2DIntArray(10, N, 0)
    for (i in 0 until N) {
        cnt[S[i] - '0'][i]++
        if (i == 0) continue
        for (j in 0 until 10) {
            cnt[j][i] += cnt[j][i - 1]
        }
    }
    var ans = 0.toModLong(MOD)
    val comb = CombinationMod(N, MOD)
    for (i in 1 until N) {
        val n = S[i] - '0'
        if (n == 0) continue
        val l = cnt[n - 1][i - 1]
        val r = cnt[n][N - 1] - cnt[n][i]
        ans += comb.aCb(l + r, l - 1)
    }
    println(ans.toLong())
}
