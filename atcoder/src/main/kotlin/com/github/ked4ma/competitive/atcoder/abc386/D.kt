package com.github.ked4ma.competitive.atcoder.abc386

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val XYC = times(M) {
        val (X, Y, C) = nextList()
        Triple(X.toInt(), Y.toInt(), C[0])
    }.sortedWith(compareBy({ it.first }, { it.second }))
    var wMin = N + 1
    XYC.forEach { (_, y, c) ->
        if (c == 'W') {
            wMin = min(wMin, y)
        } else {
            if (y >= wMin) {
                println("No")
                return
            }
        }
    }
    println("Yes")
    // val group = XYC.groupBy { it.first }
    // var bAvail = N
    // group.keys.sorted().forEach { x ->
    //     var bMax = 0
    //     var wMin = N + 1
    //     group.getValue(x).forEach { (_, y, c) ->
    //         when (c) {
    //             'B' -> bMax = max(bMax, y)
    //             'W' -> wMin = min(wMin, y)
    //         }
    //     }
    //     if (wMin < bMax || bAvail < bMax) {
    //         println("No")
    //         return
    //     }
    //     bAvail = wMin - 1
    //     _debug_println("$bAvail $bMax")
    // }
    // println("Yes")
}
