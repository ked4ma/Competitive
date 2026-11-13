package com.github.ked4ma.competitive.atcoder.awc0200

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W) = nextIntList()
    val S = times(H) { nextCharArray() }

    var i = 0
    var j = 0
    while (true) {
        var ni = i
        var nj = j
        if (S[i][j] == 'v') ni++
        if (S[i][j] == '>') nj++
        if (ni >= H || nj >= W) break
        i = ni
        j = nj
    }
    i++
    j++
    println("$i $j")
}
