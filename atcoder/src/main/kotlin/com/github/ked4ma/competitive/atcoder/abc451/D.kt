package com.github.ked4ma.competitive.atcoder.abc451

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.long.pow.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val MAX = 1_000_000_000L
    val n = mutableListOf<Pair<Long, Long>>()
    run {
        var i = 1L
        while (i <= MAX) {
            n.add(i to 10L.pow((i.toString()).length))
            i *= 2
        }
    }
    _debug_println(n)
    val set = sortedSetOf<Long>()
    fun push(x: Long) {
        set.add(x)
        if (set.size == N && set.last() < x) return
        while (set.size > N) set.remove(set.last())
    }

    fun make(i: Int = 0, a: Long = 0) {
        if (i == n.size) return
        for ((x, pad) in n) {
            val y = a * pad + x
            if (y > MAX) break
            push(y)
            make(i + 1, y)
        }
    }
    make()
    _debug_println(N == 10) { set }
    println(set.last())
}
