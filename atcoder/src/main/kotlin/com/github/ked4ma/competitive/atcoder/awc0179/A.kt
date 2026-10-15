package com.github.ked4ma.competitive.atcoder.awc0179

import com.github.ked4ma.competitive.common.input.default.*

fun main() {
    val (N, X) = nextIntList()
    val ans = StringBuilder()
    for (a in nextIntList()) {
        ans.append(if (a <= X) 'o' else 'x')
    }
    println(ans)
}
