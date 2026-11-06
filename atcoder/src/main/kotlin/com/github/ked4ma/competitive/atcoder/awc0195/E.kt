package com.github.ked4ma.competitive.atcoder.awc0195

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.int.bound.*
import com.github.ked4ma.competitive.common.models.tree.fenwick.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, X, Y) = nextIntList()
    val AB = times(N) {
        val (A, B) = nextIntList()
        A to B
    }.sortedBy { it.first }
    _debug_println(AB)
    val yList = (AB.map { it.second } + listOf(0)).sorted().distinct()
    _debug_println(yList)
    _debug_println("=====")
    val yMap = yList.withIndex().associate { it.value to it.index }
    val ft = FenwickTree(yList.size)
    var r = N - 1
    var ans = 0L
    for (l in N - 1 downTo 0) {
        if (l < r && r < N && AB[l].first + AB[r].first >= X) {
            _debug_println("add(+1): ${yMap.getValue(AB[r].second)} (${AB[r].second})")
            ft.add(yMap.getValue(AB[r].second), 1)
            r--
        }
        while (r + 1 < N && AB[l].first + AB[r + 1].first < X) {
            r++
            _debug_println("add(-1): ${yMap.getValue(AB[r].second)} (${AB[r].second})")
            ft.add(yMap.getValue(AB[r].second), -1)
        }
        val i = yList.lowerBound(Y - AB[l].second)
//        _debug_println("$l: (r:$r) ($i) ${ft.sum(i, yList.size)}")
        _debug_println((0 until yList.size).map { ft.sum(it, it + 1) }.joinToString(" "))
        ans += ft.sum(i, yList.size)
    }
    println(ans)
}
