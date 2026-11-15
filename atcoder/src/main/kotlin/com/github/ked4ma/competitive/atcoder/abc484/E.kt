package com.github.ked4ma.competitive.atcoder.abc484

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.long.bound.*
import com.github.ked4ma.competitive.common.list.long.cumlative.*
import com.github.ked4ma.competitive.common.models.tree.fenwick.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, L, R) = nextLongList().let { (N, L, R) -> Triple(N.toInt(), L, R) }
    val A = nextLongList()
    _debug_println(A.cumulativeSum())
    val values = buildSet {
        var n = 0L
        add(n)
        for (a in A) {
            n += a
            add(-n)
        }
    }.sorted()
    val valuesMap = values.withIndex().associate { it.value to it.index }
    _debug_println(values)
    val ft = FenwickTree(values.size)
    ft.add(valuesMap.getValue(0), 1)
    var n = 0L
    var ans = 0L
    for (a in A) {
        n += a
        val l = values.lowerBound(-n + L)
        val r = values.upperBound(-n + R)
        _debug_println("$l(${values.getOrNull(l)}) $r({${values.getOrNull(r)})")
        _debug_println(ft.sum(l, r))
        ans += ft.sum(l, r)
        ft.add(valuesMap.getValue(-n), 1)
    }
    println(ans)
}
