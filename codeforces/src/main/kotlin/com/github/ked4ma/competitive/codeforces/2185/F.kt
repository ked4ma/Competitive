package com.github.ked4ma.competitive.codeforces.`2185`

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.tree.segment.general.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    var (n, q) = nextIntList()
    n = 1 shl n
    val a = nextIntList()

    data class D(val i: Int, val j: Int, val k: Boolean)

    val segTree = GeneralSegmentTree.getInstance(
        n = n,
        fx = { x1, x2 ->
            var x = x1
            var y = x2
            if (x1.i < x2.i) {
                x = y.also { y = x }
            }
            val z = x.i xor y.i
            var l = 0
            var t = false
            if (!x.k && !y.k) {
                l = x.j + y.j
            } else if (x.k && !y.k) {
                l = x.j
                t = true
            } else if (!x.k && y.k) {
                l = x.j + y.j
                t = true
            }
            D(z, l, t)
        },
        fm = { _, m -> m },
        ex = D(0, 1, false)
    )

    for (i in 0 until n) {
        segTree.set(i, D(a[i], 1, false))
    }
    segTree.build()
    repeat(q) {
        val (b, c) = nextIntList().let { (b, c) -> b - 1 to c }
        segTree.update(b, D(c, 0, true))
        _debug_println(segTree.query(0, n))
        println(segTree.query(0, n).j)
        segTree.update(b, D(a[b], 1, false))
    }
}
