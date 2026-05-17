package com.github.ked4ma.competitive.atcoder.abc458

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.combimation.mod.*
import com.github.ked4ma.competitive.common.math.mod.*
import com.github.ked4ma.competitive.common.models.number.mod.long.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    MOD = MOD998244353
    var (a, b, c) = nextIntList()

    val comb = CombinationMod(a + b + c)

    var ans = 0.toModLong()
    repeat(2) {
        var g = 2
        while (true) {
            val gc = g / 2
            val ga = g - gc
            if (a < ga || c < gc) break
            if (b < g - 1) break
            val now = 1.toModLong() *
                    comb.nHk(ga, a - ga) *
                    comb.nHk(gc, c - gc) *
                    comb.nHk(a + c + 1, b - (g - 1))
            ans += now
            g++
        }
        a = c.also { c = a }
    }
    println(ans.toLong())
}
