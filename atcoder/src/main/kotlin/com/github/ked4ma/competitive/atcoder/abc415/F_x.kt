package com.github.ked4ma.competitive.atcoder.abc415

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.tree.segment.normal.general.GeneralSegmentTree
import com.github.ked4ma.competitive.common.repeat.range.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val S = nextCharArray()

    val segTree = GeneralSegmentTree.getInstance<T, T>(
        n = N,
        op = { a, b ->
            if (a.ans == 0) {
                b
            } else if (b.ans == 0) {
                a
            } else {
                var ans = max(a.ans, b.ans)
                if (a.rc == b.lc) ans = max(ans, a.r + b.l)
                val lc = a.lc
                var l = a.l
                val rc = b.rc
                var r = b.r
                if (a.same && a.lc == b.lc) l += b.l
                if (b.same && a.rc == b.rc) r += a.r
                val same = a.same && b.same && a.lc == b.lc
                T(ans, lc, l, rc, r, same)
            }
        },
        mapping = { _, b -> b },
        e = T(0, '?', 0, '?', 0, false)
    )

    fun newT(c: Char) = T(1, c, 1, c, 1, true)
    for (i in range(N)) {
        segTree.set(i, newT(S[i]))
    }

    repeat(Q) {
        val query = nextList()
        when (query[0]) {
            "1" -> {
                val i = query[1].toInt() - 1
                val c = query[2][0]
                segTree.set(i, newT(c))
            }

            "2" -> {
                val l = query[1].toInt() - 1
                val r = query[2].toInt()
                println(segTree.query(l, r).ans)
            }
        }
    }
}

private data class T(val ans: Int, val lc: Char, val l: Int, val rc: Char, val r: Int, val same: Boolean)
