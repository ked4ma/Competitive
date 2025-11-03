package com.github.ked4ma.competitive.atcoder.abc408

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.tree.segment.*
import com.github.ked4ma.competitive.common.repeat.range.*
import kotlin.math.max
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, D, R) = nextIntList()
    val H = nextIntList().map { it - 1 }
    val HI = H.let {
        val arr = sizedIntArray(N, 0)
        for (i in range(N)) {
            arr[it[i]] = i
        }
        arr
    }

    val dp = sizedLongArray(N, 0)
    val segTree = SegmentTree(
        n = N,
        fx = { x1, x2 -> max(x1, x2) },
        fm = { _, m2 -> m2 },
        ex = -1,
    )
    for (h in range(N)) {
        if (h >= D) {
            val j = HI[h - D]
            segTree.update(j, dp[j])
        }
        val i = HI[h]
        // [l, r)
        val l = max(0, i - R)
        val r = min(N, i + R + 1)
        dp[i] = segTree.query(l, r) + 1
    }
    println(dp.max())
}
