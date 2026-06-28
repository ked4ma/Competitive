package com.github.ked4ma.competitive.atcoder.abc464

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W) = nextIntList()
    val C = times(H) { nextCharArray() }

    var u = 0
    var b = H
    var l = 0
    var r = W
    while (C[u].all { it == '.' }) u++
    while (C[b - 1].all { it == '.' }) b--
    while ((0 until H).all { C[it][l] == '.' }) l++
    while ((0 until H).all { C[it][r - 1] == '.' }) r--
    for (h in u until b) {
        for (w in l until r) {
            print(C[h][w])
        }
        println()
    }
}
