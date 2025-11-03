package com.github.ked4ma.competitive.atcoder.abc416

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import com.github.ked4ma.competitive.common.repeat.range.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K, X) = nextIntList()
    val S = times(N) { next() }
    var list = mutableListOf("")
    repeat(K) {
        val next = mutableListOf<String>()
        for (s in list) {
            for (i in range(N)) {
                next.add("$s${S[i]}")
            }
        }
        list = next
    }
    list.sort()
    println(list[X - 1])
}
