package com.github.ked4ma.competitive.atcoder.awc0198

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.mod.*

fun main() {
    val (N, P) = nextLongList()
    MOD = P
    val A = nextLongList()
    var ans = 1L
    for (a in A) {
        ans = ans.timesMod(a)
        _debug_println(ans)
    }
    println(ans)
}
