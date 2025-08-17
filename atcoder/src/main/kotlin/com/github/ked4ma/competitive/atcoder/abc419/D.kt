package com.github.ked4ma.competitive.atcoder.abc419

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.*
import com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.raq.max.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val S = nextCharArray()
    val T = nextCharArray()

    val segTree = LazySegmentTree.RAQ_RMQ(N, ex = 0L)
    repeat(M) {
        val (l, r) = nextIntList()
        segTree.update(l - 1, r, 1)
    }
    val ans = StringBuilder()
    for (i in 0 until N) {
        if (segTree.query(i, i + 1) % 2 == 0L) {
            ans.append(S[i])
        } else {
            ans.append(T[i])
        }
    }
    println(ans)
}
