package com.github.ked4ma.competitive.atcoder.abc455

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.array.int.output.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    data class C(var p: C? = null, var c: C? = null)

    val n = sizedArray(N) { C() }

    repeat(Q) {
        val (c, p) = nextIntList().map { it - 1 }
        val nc = n[c]
        val np = n[p]
        nc.p?.c = null
        np.c = nc
        nc.p = np
    }

    val ans = sizedIntArray(N, 0)
    for (i in 0 until N) {
        var cur: C? = n[i]
        if (n[i].p != null) continue
        var cnt = 0
        while (cur != null) {
            cnt++
            cur = cur.c
        }
        ans[i] = cnt
    }
    ans.println(" ")
}
