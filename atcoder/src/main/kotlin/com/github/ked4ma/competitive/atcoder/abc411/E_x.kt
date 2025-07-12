package com.github.ked4ma.competitive.atcoder.abc411

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.mod.*
import com.github.ked4ma.competitive.common.models.number.mod.long.*
import com.github.ked4ma.competitive.common.models.number.mod.long.pow.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val MOD = MOD998244353
    val N = nextInt()
    val m = 6
    val A = times(N) {
        nextIntList()
    }
    val xs = A.mapIndexed { i, list -> list.map { it to i } }.flatten().sortedBy { it.first }

    var ans = 0.toModLong(MOD)
    var pre = 0
    var prod = 1.toModLong(MOD)
    var zero = N
    val cnt = sizedIntArray(N, 0)
    for ((x, i) in xs) {
        var p = 0.toModLong(MOD)
        if (zero == 0) p = prod / m.toModLong(MOD).pow(N)
        ans += (1.toModLong(MOD) - p) * (x - pre)
        pre = x

        if (cnt[i] == 0) {
            zero--
        } else {
            prod /= cnt[i]
        }
        cnt[i]++
        prod *= cnt[i]
    }
    println(ans.toLong())
}
