package com.github.ked4ma.competitive.atcoder.awc0170

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.array.long.d1.bitset.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.div.ceil.*
import com.github.ked4ma.competitive.common.number.long.bit.*
import kotlin.math.abs
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList()
    val s = A.sum()

    val n = 200 * 1005
    val m = n.ceilDiv(64)
    val arr = sizedLongArray(m)
    arr[0] = 1
    for (a in A) {
        arr.orShl(a)
    }
    var ans = s
    for (t in 0 until (n + 1) / 2) {
        val i = t / 64
        val j = t % 64
        if (arr[i].bit(j)) {
            val a = s - t
            ans = min(ans, abs(t - a))
        }
    }
    println(ans)
}
