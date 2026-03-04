package com.github.ked4ma.competitive.codeforces.`2199`

import com.github.ked4ma.competitive.common.array.boolean.d1.*
import com.github.ked4ma.competitive.common.array.long.bound.*
import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.array.long.output.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.abs

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (n, q) = nextIntList()
    val a = nextIntList()
    val x = nextLongList()
    val arr = sizedLongArray(n)
    val pm = sizedBooleanArray(n)
    val judge = sizedBooleanArray(n, true)
    for (i in 1 until n) {
        if (a[i] == a[i - 1]) {
            judge[i] = false
            arr[i] = 2 + arr[i - 1]
        } else {
            pm[i] = a[i] < a[i - 1]
            arr[i] = abs(a[i] - a[i - 1]) + arr[i - 1]
        }
    }
    _debug_println(arr)
    _debug_println(judge)
    _debug_println(pm)
    val ans = sizedLongArray(q)
    for (j in 0 until q) {
        val b = x[j]
        val i = arr.lowerBound(b - 1)
        if (i < n) {
            val m = arr[i] - (b - 1)
            if (!judge[i] && m > 0) {
                ans[j] = 0
                continue
            }
            val p = if (pm[i]) 1 else -1
            _debug_println("$b (${b - 1}, ${arr[i] - (b - 1)}): $i : ${a[i] + p * (arr[i] - (b - 1))} : $p")
            ans[j] = a[i] + p * (arr[i] - (b - 1))
        } else {
            ans[j] = -1
        }
    }
    ans.println(" ")
}
