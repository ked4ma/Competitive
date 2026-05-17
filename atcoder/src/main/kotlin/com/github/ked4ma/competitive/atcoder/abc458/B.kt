package com.github.ked4ma.competitive.atcoder.abc458

import com.github.ked4ma.competitive.common.array.int.d2.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W) = nextIntList()
    val arr = sized2DIntArray(H, W, 0)
    val dirs = listOf(
        0 to 1,
        0 to -1,
        1 to 0,
        -1 to 0,
    )
    for (h in 0 until H) {
        for (w in 0 until W) {
            var cnt = 0
            for ((dh, dw) in dirs) {
                val nh = h + dh
                val nw = w + dw
                if (nh in 0 until H && nw in 0 until W) cnt++
            }
            arr[h][w] = cnt
        }
    }
    println(arr.joinToString("\n") { it.joinToString(" ") })
}
