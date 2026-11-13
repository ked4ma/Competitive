package com.github.ked4ma.competitive.atcoder.awc0196

import com.github.ked4ma.competitive.common.boolean.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val S = nextCharArray()
    var c = false
    var b = false
    for (s in S) {
        when (s) {
            'C' -> c = true
            'B' -> b = true
        }
    }
    println((c && b).toYesNo())
}
