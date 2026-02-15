package com.github.ked4ma.competitive.atcoder.abc445

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.array.long.output.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.long.pow.*
import com.github.ked4ma.competitive.common.math.mod.*
import com.github.ked4ma.competitive.common.number.inf.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val M = 10000001
    val arr = sizedIntArray(M, INT_INF)
    arr[0] = 1
    arr[1] = 1
    for (i in 2 until M) {
        if (arr[i] < INT_INF) continue
        for (j in i until M step i) {
            arr[j] = min(arr[j], i)
        }
    }
    val T = nextInt()
    repeat(T) {
        solve(arr)
    }
}

private fun solve(arr: IntArray) {
    val MOD = MOD998244353
    val N = nextInt()
    val A = nextIntList()
    val B = sizedArray(N) { mutableMapOf<Int, Int>().withDefault { 0 } }
    for (i in 0 until N) {
        var a = A[i]
        while (a > 1) {
            val p = arr[a]
            B[i][p] = B[i].getValue(p) + 1
            a /= p
        }
    }
    val map = mutableMapOf<Int, IntArray>()
    for (b in B) {
        for ((k, v) in b) {
            val order = map.computeIfAbsent(k) { intArrayOf(0, 0) }
            if (v >= order[0]) {
                order[1] = order[0]
                order[0] = v
            } else if (v > order[1]) {
                order[1] = v
            }
        }
    }
    var base = 1L
    for ((k, l) in map) {
        base = base.timesMod(k.toLong().powMod(l[0].toLong(), MOD), MOD)
    }
    val ans = sizedLongArray(N)
    for (i in 0 until N) {
        var div = 1L
        for ((k, v) in B[i]) {
            var m = 0L
            if (v == map.getValue(k)[0]) m = map.getValue(k).let { (x, y) -> x - y }.toLong()
            div = div.timesMod(k.toLong().powMod(m, MOD), MOD)
        }
        ans[i] = base.divMod(div, MOD)
    }
    ans.println(" ")
}
