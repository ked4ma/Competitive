package com.github.ked4ma.competitive.atcoder.abc437

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.tree.segment.*
import kotlin.math.abs

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val uMaxSeg = SegmentTree.RUQ_RMQ(N)
    val uMinSeg = SegmentTree.RUQ_RmQ(N)
    val vMaxSeg = SegmentTree.RUQ_RMQ(N)
    val vMinSeg = SegmentTree.RUQ_RmQ(N)
    repeat(N) {
        val (X, Y) = nextLongList()
        uMaxSeg.set(it, X + Y)
        uMinSeg.set(it, X + Y)
        vMaxSeg.set(it, X - Y)
        vMinSeg.set(it, X - Y)
    }
    uMaxSeg.build()
    uMinSeg.build()
    vMaxSeg.build()
    vMinSeg.build()

    repeat(Q) {
        val query = nextIntList()
        when (query[0]) {
            1 -> {
                val (_, i, x, y) = query
                uMaxSeg.update(i - 1, x.toLong() + y)
                uMinSeg.update(i - 1, x.toLong() + y)
                vMaxSeg.update(i - 1, x.toLong() - y)
                vMinSeg.update(i - 1, x.toLong() - y)
            }

            2 -> {
                val (_, L, R, x, y) = query
                val u = x + y
                val v = x - y
                println(
                    maxOf(
                        abs(u - uMaxSeg.query(L - 1, R)),
                        abs(u - uMinSeg.query(L - 1, R)),
                        abs(v - vMaxSeg.query(L - 1, R)),
                        abs(v - vMinSeg.query(L - 1, R)),
                    )
                )
            }
        }
    }
}
