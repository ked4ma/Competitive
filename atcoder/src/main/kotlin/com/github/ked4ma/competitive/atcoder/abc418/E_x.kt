package com.github.ked4ma.competitive.atcoder.abc418

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.combimation.*
import com.github.ked4ma.competitive.common.math.gcd.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.abs

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val XY = times(N) {
        val (X, Y) = nextLongList()
        Data(X, Y)
    }
    val cntMap = mutableMapOf<Data, Long>().withDefault { 0 }
    val centerMap = mutableMapOf<Data, Long>().withDefault { 0 }
    for (i in 0 until N) {
        val (x1, y1) = XY[i]
        for (j in i + 1 until N) {
            val (x2, y2) = XY[j]
            val k = if (x1 == x2) {
                Data(0, Long.MAX_VALUE)
            } else if (y1 == y2) {
                Data(Long.MAX_VALUE, 0L)
            } else {
                val x = if (x1 < x2) x2 - x1 else x1 - x2
                val y = if (x1 < x2) y2 - y1 else y1 - y2
                val z = gcd(x, abs(y))
                Data(x / z, y / z)
            }
            val k2 = Data(x1 + x2, y1 + y2)
            cntMap[k] = cntMap.getValue(k) + 1
            centerMap[k2] = centerMap.getValue(k2) + 1
        }
    }
    var ans = 0L
    cntMap.values.forEach { cnt ->
        if (cnt < 2) return@forEach
        ans += combination(cnt, 2)
    }
    centerMap.values.forEach { cnt ->
        if (cnt < 2) return@forEach
        ans -= combination(cnt, 2)
    }
    println(ans)
}

private data class Data(val x: Long, val y: Long)
