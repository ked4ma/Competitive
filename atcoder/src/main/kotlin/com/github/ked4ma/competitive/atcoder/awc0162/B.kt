package com.github.ked4ma.competitive.atcoder.awc0162

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, X) = nextIntList().let { (N, X) -> N to X.toLong() }
    val AB = times(N) {
        val (A, B) = nextLongList()
        A to B
    }.groupBy { it.first }.mapValues { (_, v) -> v.maxOf { it.second } }
    var ans = 0L
    for ((k, v) in AB) {
        if (k < X && v > 0) ans += v
    }
    println(ans)
}
