package com.github.ked4ma.competitive.atcoder.awc0169

import com.github.ked4ma.competitive.common.boolean.*
import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.min

fun main() {
    val (N, M, K) = nextIntList()
    val W = nextLongList()
    val R = nextLongList().sum()
    val x = W.sortedDescending().take(min(K, N)).sum()
    println((x >= R).toYesNo())
}
