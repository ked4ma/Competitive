package com.github.ked4ma.competitive.codeforces.`2184`

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun fib(d: Int): IntArray {
    if (d == 0) {
        return intArrayOf(0, 1)
    } else if (d == 1) {
        return intArrayOf(0, 1, 1)
    } else if (d == 2) {
        return intArrayOf(0, 1, 1, 2)
    }
    val arr = sizedIntArray(80)
    arr[1] = 1
    arr[2] = 1
    arr[3] = 2
    arr[4] = 3
    arr[5] = 1
    var i = 5
    var diff = intArrayOf(4, 3, 1)
    repeat(d - 3) {
        for (j in 0 until diff.size) {
            arr[i + j] += diff[j]
        }
        val ndiff = sizedIntArray(diff.size + 1)
        ndiff[0] = diff[0] + 1
        ndiff[1] = diff[0] + diff[1] - 1
        for (j in 2 until ndiff.size - 1) {
            ndiff[j] = diff[j - 1] + diff[j]
        }
        ndiff[ndiff.size - 1] = 1
        diff = ndiff
        i++
        _debug_println(arr)
    }
    return arr
}

private fun solve() {
    val (n, k) = nextIntList()
    var m = 1
    var d = 0
    while (m < n) {
        d++
        m *= 2
    }
    val arr = fib(d)
    val cum = sizedIntArray(arr.size)
    for (i in 1 until arr.size) {
        cum[i] = cum[i - 1] + arr[i]
    }
    if (arr.size <= k) {
        println(0)
        return
    }
    println(n - cum[k])
}
