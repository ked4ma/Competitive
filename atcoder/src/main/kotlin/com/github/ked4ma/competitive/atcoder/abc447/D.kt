package com.github.ked4ma.competitive.atcoder.abc447

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.int.bound.*
import com.github.ked4ma.competitive.common.number.inf.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = nextCharArray()
    val N = S.size
    val arr = sizedArray(3) { mutableListOf<Int>() }
    S.forEachIndexed { i, c ->
        arr[c - 'A'].add(i)
    }
    arr[1].add(INT_INF)
    arr[2].add(INT_INF)
    _debug_println(arr)
    _debug_println("=====")
    var lj = 0
    var lk = 0
    var ans = 0
    for (i in arr[0]) {
        val j = arr[1][arr[1].upperBound(max(i, lj))]
        if (j >= INT_INF) break
        val k = arr[2][arr[2].upperBound(max(j, lk))]
        if (k >= INT_INF) break
        _debug_println("$i $j $k")
        ans++
        lj = j
        lk = k
    }
    println(ans)
}
