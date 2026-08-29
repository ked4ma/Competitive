package com.github.ked4ma.competitive.atcoder.abc473

import com.github.ked4ma.competitive.common.boolean.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.*
import com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.raq.min.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val S = nextCharArray()
    val Q = nextInt()
    val segTree = LazySegmentTree.RAQ_RmQ(N + 1)
    run {
        var sum = 0L
        segTree.set(0, sum)
        for (i in 0 until N) {
            val x = if (S[i] == 'A') 1 else -1
            sum += x
            segTree.set(i + 1, sum)
        }
    }
    repeat(Q) {
        val (t, a, b) = nextList()
        when (t.toInt()) {
            1 -> {
                val i = a.toInt()
                val c = b[0]
                if (S[i - 1] != c) {
                    S[i - 1] = c
                    val x = if (c == 'A') 2 else -2
                    segTree.apply(i, N + 1, x.toLong())
                }
            }

            2 -> {
                val l = a.toInt()
                val r = b.toInt()
                val s = segTree.query(l - 1, l)
                val min = segTree.query(l, r + 1)
                _debug_println(min - s)
                println((min - s >= 0).toYesNo())
            }
        }
    }
}
