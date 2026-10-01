package com.github.ked4ma.competitive.atcoder.awc0169

import com.github.ked4ma.competitive.common.input.default.*

fun main() {
    val (N, S) = nextLongList()
    val W = nextLongList()
    var ans = 0
    var t = 0L
    for (w in W) {
        t += w
        if (t >= S) {
            ans++
            t = 0
        }
    }
    println(ans)
}
