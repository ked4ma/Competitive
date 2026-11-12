package com.github.ked4ma.competitive.atcoder.awc0198

import com.github.ked4ma.competitive.common.boolean.*
import com.github.ked4ma.competitive.common.input.default.*

fun main() {
    val (A, B) = nextIntList()
    println((A % B == 0).toYesNo())
}
