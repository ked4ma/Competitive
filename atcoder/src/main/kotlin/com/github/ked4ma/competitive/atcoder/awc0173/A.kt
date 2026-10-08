package com.github.ked4ma.competitive.atcoder.awc0173

import com.github.ked4ma.competitive.common.boolean.*
import com.github.ked4ma.competitive.common.input.default.*

fun main() {
    val (N, B) = nextLongList()
    println((nextLongList().sum() <= B).toYesNo())
}
