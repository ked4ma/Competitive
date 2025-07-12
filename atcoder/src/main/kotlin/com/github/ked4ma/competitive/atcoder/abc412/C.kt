package com.github.ked4ma.competitive.atcoder.abc412

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) { solve() }
}

private fun List<Int>.lower(v: Int): Int {
    var l = 0
    var r = this.size
    while (l + 1 < r) {
        val m = (l + r) / 2
        if (this[m] < v) {
            l = m
        } else {
            r = m
        }
    }
    return l
}

private fun solve() {
    val N = nextInt()
    val S = nextIntList()
    var s = S.first()
    val S2 = ArrayDeque(S.subList(1, N - 1).sorted())
    val END = S.last()
    _debug_println("$s $S2 $END")
    var cnt = 2
    while (2 * s < END) {
        var next = -1
        while (S2.isNotEmpty() && 2 * s >= S2.first()) {
            next = S2.removeFirst()
        }
        if (next < 0) {
            cnt = -1
            break
        }
        s = next
        cnt++
        _debug_println("$s $cnt")
    }
    println(cnt)
}
