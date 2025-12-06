package com.github.ked4ma.competitive.atcoder.abc434

import com.github.ked4ma.competitive.common.array.int.d2.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.cumlative.d2sum.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val data = times(N) {
        val (u, d, l, r) = nextIntList()
        Rect(u - 1, d, l - 1, r)
    }
    val arr = sized2DIntArray(2001, 2001, 0)
    for ((u, d, l, r) in data) {
        arr[u][l] += 1
        arr[u][r] += -1
        arr[d][l] += -1
        arr[d][r] += 1
    }
    // >
    for (i in 0 until 2000) {
        for (j in 0 until 2000) {
            arr[i][j + 1] += arr[i][j]
        }
    }
    // v
    for (i in 0 until 2000) {
        for (j in 0 until 2000) {
            arr[i + 1][j] += arr[i][j]
        }
    }
    val sky = (0 until 2000).sumOf { i ->
        (0 until 2000).count { j -> arr[i][j] == 0 }
    }
    for (i in 0 until 2000) {
        for (j in 0 until 2000) {
            if (arr[i][j] > 1) arr[i][j] = 0
        }
    }
    _debug_println(arr.take(10).map { it.take(10) })
//    _debug_println(sky)
    val cum = CumulativeSum2D(arr)
    _debug_println("-----")
    _debug_println(cum.data.take(10).map { it.take(10) })
    _debug_println("-----")
    _debug_println(cum.getSumOf(0, 0, 2, 2))
    for ((u, d, l, r) in data) {
        println(sky + cum.getSumOf(l, u, r - 1, d - 1))
    }
}

private data class Rect(val u: Int, val d: Int, val l: Int, val r: Int)
