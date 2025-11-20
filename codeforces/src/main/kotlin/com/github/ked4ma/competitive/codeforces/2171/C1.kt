package com.github.ked4ma.competitive.codeforces.`2171`

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
    if (aScore == bScore) {
        println("Tie")
        return
    }
    for (i in 0 until n) {
        if (a[i] == b[i]) continue
        if ((i % 2 == 0 && aScore < bScore) || (i % 2 == 1 && aScore > bScore)) {
            aScore = 1 - aScore
            bScore = 1 - bScore
        }
    }
    println(if (aScore > bScore) "Ajisai" else "Mai")
}
