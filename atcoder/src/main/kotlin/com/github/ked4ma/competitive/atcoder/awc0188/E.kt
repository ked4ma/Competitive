package com.github.ked4ma.competitive.atcoder.awc0188

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.abs

fun main() {
    val N = nextInt()
    val C = nextLongList().sorted()

    _debug_println(C)

    val q = ArrayDeque<Long>()
    val q2 = ArrayDeque<Long>()
    q2.addAll(C)
    q.add(q2.removeLast())
    while (q2.isNotEmpty()) {
        val f = q2.first()
        val f1 = abs(f - q.first())
        val f2 = abs(f - q.last())
        val l = q2.last()
        val l1 = abs(l - q.first())
        val l2 = abs(l - q.last())
        val max = maxOf(f1, f2, l1, l2)
        when (max) {
            f1 -> q.addFirst(q2.removeFirst())
            f2 -> q.addLast(q2.removeFirst())
            l1 -> q.addFirst(q2.removeLast())
            l2 -> q.addLast(q2.removeLast())
        }
    }
    var ans = 0L
    for ((a, b) in q.toList().windowed(2, 1)) {
        ans += abs(a - b)
    }
    println(ans)
    _debug_println(q.toList())
}
