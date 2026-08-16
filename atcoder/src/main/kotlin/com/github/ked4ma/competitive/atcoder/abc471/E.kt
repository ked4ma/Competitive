package com.github.ked4ma.competitive.atcoder.abc471

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.combimation.mod.*
import com.github.ked4ma.competitive.common.math.mod.*
import com.github.ked4ma.competitive.common.models.number.mod.long.*
import com.github.ked4ma.competitive.common.models.number.mod.long.pow.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    MOD = MOD998244353
    val (N, K) = nextIntList()
    val A = nextLongList().map { it.toModLong() }
    val zero = 0.toModLong()

    val comb = CombinationMod(200_005)

    val s = A.fold(zero) { acc, n -> acc + n }
    val s2 = A.fold(zero) { acc, n -> acc + n.pow(2) }
    val ab = (s.pow(2) - s2) * comb.aCb(N - 2, K - 2)
    val a2 = s2 * comb.aCb(N - 1, K - 1)
    val ans = a2 + ab
    println(ans.toLong())
}
