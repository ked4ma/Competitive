package com.github.ked4ma.competitive.atcoder.awc0188

import com.github.ked4ma.competitive.common.boolean.*
import com.github.ked4ma.competitive.common.input.default.*

fun main() {
    val (N, A, B) = nextIntList()
    println((N * A <= B).toYesNo())
}
