package com.github.ked4ma.competitive.atcoder.abc481

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val Q = nextInt()
    val map = mutableMapOf<String, Int>()
    var i = 0
    repeat(Q) {
        val s = next()
        if (s !in map) {
            i++
            map[s] = i
        }
        println(map.getValue(s))
    }
}
