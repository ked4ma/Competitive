package com.github.ked4ma.competitive.atcoder.awc0152

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, S) = nextULongList().let { (N, S) -> N.toInt() to S }
    val P = nextULongList()

    if (N == 1) {
        println(if (P[0] == S) "ALMOST" else "NO")
        return
    }

    fun f(range: IntRange) = buildList {
        add(0UL)
        for (i in range) {
            val p = P[i]
            val size = this.size
            for (j in 0 until size) {
                if (this[j] + p <= S) add(this[j] + p)
            }
        }
    }.groupingBy { it }.eachCount()

    val l = f(0 until N / 2)
    val r = f(N / 2 until N)
    var cnt = 0L
    for ((x, c) in l) {
        cnt += c.toLong() * r.getOrDefault(S - x, 0).toLong()
    }
    println(
        when (cnt) {
            0L -> "NO"
            1L -> "ALMOST"
            else -> "YES"
        }
    )
}
