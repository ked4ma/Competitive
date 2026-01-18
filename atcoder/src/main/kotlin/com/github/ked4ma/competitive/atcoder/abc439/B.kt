package com.github.ked4ma.competitive.atcoder.abc439

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.int.pow.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val vis = mutableSetOf<Int>()
    var n = N
    while (n != 1) {
        if (n in vis) {
            println("No")
            return
        }
        vis.add(n)
        var k = n
        var m = 0
        while (k > 0) {
            m += (k % 10).pow(2)
            k /= 10
        }
        n = m
    }
    println("Yes")
}
