package com.github.ked4ma.competitive.codeforces.`2171`

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    val n = nextInt()
    val a = nextIntList().toIntArray()
    val b = nextIntList().toIntArray()
    var aScore = a.fold(0) { acc, x -> acc xor x }
    var bScore = b.fold(0) { acc, x -> acc xor x }
    _debug_println("$aScore $bScore")
    if (aScore == bScore) {
        println("Tie")
        return
    }
    for (i in 0 until n) {
        if (a[i] == b[i]) continue
        val aScore2 = aScore xor a[i] xor b[i]
        val bScore2 = bScore xor a[i] xor b[i]
        if (i % 2 == 0) {
            if (aScore2 > bScore2) {
                aScore = aScore2
                bScore = bScore2
            }
        } else {
            if (aScore2 < bScore2) {
                aScore = aScore2
                bScore = bScore2
            }
        }
    }
    println(if (aScore > bScore) "Ajisai" else "Mai")
}
