package com.github.ked4ma.competitive.atcoder.abc439

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.set.multi.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList()
    val set7b = MultiSet<Int>()
    val set3b = MultiSet<Int>()
    val set7a = MultiSet<Int>()
    val set3a = MultiSet<Int>()
    for (a in A) {
        if (a % 7 == 0) set7a.add(a)
        if (a % 3 == 0) set3a.add(a)
    }
    _debug_println(set7a)
    _debug_println(set3a)
    var ans = 0L
    for (i in 0 until N) {
        val a = A[i]
        set7a.remove(a)
        set3a.remove(a)
        if (a % 5 == 0) {
            val b = a / 5 * 7
            val c = a / 5 * 3
            ans += set7b.count(b).toLong() * set3b.count(c)
            ans += set7a.count(b).toLong() * set3a.count(c)
        }
        if (a % 7 == 0) set7b.add(a)
        if (a % 3 == 0) set3b.add(a)
    }
    println(ans)
}
