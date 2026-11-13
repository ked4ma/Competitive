package com.github.ked4ma.competitive.atcoder.awc0200

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val set = TreeSet<Int>()
    set.addAll((-100_005..100_005).toList())
    var x = 0
    repeat(N) {
        val X = nextInt()
        if (X !in -100_001..100_001) return@repeat
        set.remove(X)
        if (x != X) return@repeat
        val l = set.floor(x)
        val r = set.ceiling(x)
        if (r - x > x - l) {
            x = l
        } else {
            x = r
        }
        _debug_println(x)
    }
    println(x)
}
