package com.github.ked4ma.competitive.atcoder.abc456

import com.github.ked4ma.competitive.common.array.long.d2.*
import com.github.ked4ma.competitive.common.array.long.d2.chmin.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.tree.segment.normal.general.*
import com.github.ked4ma.competitive.common.number.inf.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private operator fun Array<LongArray>.times(other: Array<LongArray>): Array<LongArray> {
    val c = sized2DLongArray(2, 2, LONG_INF)
    for (i in 0 until 2) {
        for (j in 0 until 2) {
            for (k in 0 until 2) {
                c.chmin(i, k, this[i][j] + other[j][k])
            }
        }
    }
    return c
}

private val I = arrayOf(
    longArrayOf(0, LONG_INF),
    longArrayOf(LONG_INF, 0)
)

private fun solve() {
    val (N, K) = nextIntList()
    val A = nextLongList()

    val seg = GeneralSegmentTree.getInstance<Array<LongArray>, Array<LongArray>>(
        n = N,
        op = { a, b -> a * b },
        mapping = { _, f -> f },
        e = I,
    )
    for (i in 0 until N) {
        val d = arrayOf(
            longArrayOf(A[i], 0),
            longArrayOf(A[i], LONG_INF),
        )
        seg.set(i, d)
    }
    fun f(k: Int): Long {
        var res = LONG_INF
        for (l in 0 until N - k + 1) {
            val d = seg.query(l, l + k)
            res = min(res, d[1][0])
        }
        return res
    }

    var ans = f(K)
    if (K < N) ans = min(ans, f(K + 1))
    println(ans)
}
