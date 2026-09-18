package com.github.ked4ma.competitive.atcoder.awc0160

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.set.multi.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val A = nextLongList()
    val set = MultiSet<Long>()
    set.addAll(A)
    var sum = A.sum()
    repeat(Q) {
        val (t, x, r) = nextIntList()
        if (r == 1) return@repeat
        val a = if (t == 1) {
            set.last()
        } else {
            set.first()
        }
        set.remove(a)
        set.add(x.toLong())
        sum += x.toLong() - a
    }
    println(sum)
}
