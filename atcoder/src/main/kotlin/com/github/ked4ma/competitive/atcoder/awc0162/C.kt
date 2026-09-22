package com.github.ked4ma.competitive.atcoder.awc0162

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.long.bound.*
import com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.*
import com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.ruq.min.*
import com.github.ked4ma.competitive.common.number.inf.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, D) = nextIntList()
    val map = mutableMapOf<Long, LongArray>()
    repeat(N) {
        val (A, C) = nextLongList()
        val arr = map.getOrPut(A) { longArrayOf(LONG_INF, LONG_INF) }
        if (C < arr[0]) {
            arr[1] = arr[0]
            arr[0] = C
        } else if (C < arr[1]) {
            arr[1] = C
        }
    }
    val A = map.keys.sorted()
    val n = A.size
    val segTree = LazySegmentTree.RUQ_RmQ(A.size)
    for (i in 0 until n) {
        segTree.set(i, map.getValue(A[i])[0])
    }

    var ans = LONG_INF
    for (i in 0 until n) {
        val a = A[i]
        val arr = map.getValue(a)
        if (a >= D) {
            ans = min(ans, arr[0])
        }
        val l = A.lowerBound(D - a)
        if (l < n) {
            segTree.set(i, arr[1])
            val c2 = segTree.query(l, n)
            ans = min(ans, arr[0] + c2)
            segTree.set(i, arr[0])
        }
    }
    if (ans == LONG_INF) ans = -1
    println(ans)
}
