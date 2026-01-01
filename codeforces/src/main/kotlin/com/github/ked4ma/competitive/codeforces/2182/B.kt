package com.github.ked4ma.competitive.codeforces.`2182`

import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    val (a, b) = nextIntList()
    fun calc(x: Int, y: Int): Int {
        var i = x
        var j = y
        var k = 0
        var n = 1
        while (true) {
            if (k % 2 == 0) {
                if (i < n) return k
                i -= n
            } else {
                if (j < n) return k
                j -= n
            }
            k++
            n *= 2
        }
    }
    println(max(calc(a, b), calc(b, a)))
}
