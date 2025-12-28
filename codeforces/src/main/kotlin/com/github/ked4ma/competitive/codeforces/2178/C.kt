package com.github.ked4ma.competitive.codeforces.`2178`

import com.github.ked4ma.competitive.common.debug._debug_println
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.tree.segment.lazy.legacy.general.*
import com.github.ked4ma.competitive.common.number.inf.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private data class S(val x: Long = 0, val n: Long = 0) {
    fun eval() = n + x
}

private fun solve() {
    val n = nextInt()
    val a = nextLongList()
    val segTree = GeneralLazySegmentTree.instanceOf(
        n = n,
        fx = { a, b -> if (a.eval() >= b.eval()) a else b },
        fa = { a, b -> S(a.x, a.n + b.n) },
        fm = { a, b -> S(a.x, a.n + b.n) },
        ex = S(n = -LONG_INF),
        em = S(n = 0),
    )
    for (i in 0 until n) {
        segTree.set(i, S(a[i]))
    }
    segTree.build()

    for (i in 1 until n) {
        val s = segTree.query(0, i)
        _debug_println("$i: $s")
        segTree.update(i, i + 1, S(a[i], s.eval()))
        segTree.update(0, i, S(n = -a[i]))
        _debug_println((0 until n).map { segTree.query(it, it + 1) }.joinToString(" "))
    }
    _debug_println((0 until n).map { segTree.query(it, it + 1) }.joinToString(" "))
    _debug_println(segTree.query(0, n))
    println((0 until n).map { segTree.query(it, it + 1).n }.max())
}
