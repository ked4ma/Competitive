package com.github.ked4ma.competitive.atcoder.abc405

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.combimation.mod.*
import com.github.ked4ma.competitive.common.math.mod.*
import com.github.ked4ma.competitive.common.models.number.mod.long.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val MOD = MOD998244353
    val M = 4_000_000
    val comb = CombinationMod(M, MOD)

    val (A, B, C, D) = nextIntList()
    _debug_println("$A $B $C $D")
    var ans = 0.toModLong(MOD)
    for (c in 0..C) {
        _debug_println(C == 1) { "$c:: ${A + C - c + 1}: ${comb.nHk(A + C - c + 1, B)} ${comb.aCb(D + c - 1, c)}" }
        ans += 1.toModLong(MOD) * comb.nHk(A + C - c + 1, B) * comb.aCb(D + c - 1, c)
    }
    println(ans.toLong())
    // val fac = sizedLongArray(M + 1, 0)
    // val finv = sizedLongArray(M + 1, 0)
    // val inv = sizedLongArray(M + 1, 0)
    // run {
    //     fac[0] = 1
    //     fac[1] = 1
    //     finv[0] = 1
    //     finv[1] = 1
    //     inv[1] = 1
    //     for (i in 2..M) {
    //         fac[i] = fac[i - 1].timesMod(i.toLong(), MOD)
    //         inv[i] = MOD - inv[(MOD % i).toInt()].timesMod(MOD / i, MOD)
    //         finv[i] = finv[i - 1].timesMod(inv[i], MOD)
    //     }
    // }
    // val (A, B, C, D) = nextIntList()
    // var ans = 0.toModLong(MOD)
    // for (c in 0..C) {
    //     ans += (fac[A + B + C - c] * finv[A + C - c] * finv[B]) *
    //             (fac[D + c] * finv[D] * finv[c])
    //     ans += (fac[A + C - c]) *
    //             ()
    //     _debug_println(A + B + C + D == 4) { ans }
    // }
    // println(ans.toLong())
}
