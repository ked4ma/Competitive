package com.github.ked4ma.competitive.atcoder.awc0174

import com.github.ked4ma.competitive.common.boolean.*
import com.github.ked4ma.competitive.common.input.default.*

fun main() {
    val (H, W) = nextIntList()
    var ok = true
    for (i in 0 until H) {
        if (next().all { it == 'x' }) {
            ok = false
            break
        }
    }
    println(ok.toYesNo())
}
