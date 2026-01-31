package com.github.ked4ma.competitive.codeforces.`2193`

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    val (n, ax, ay, bx, by) = nextIntList()
    val x = nextIntList() + listOf(bx)
    val y = nextIntList() + listOf(by)
    val map = mutableMapOf<Int, MutableList<Int>>()
    for (i in 0 until n + 1) {
        map.putIfAbsent(x[i], mutableListOf())
        map.getValue(x[i]).add(i)
    }
    _debug_println(map)
    val map2 = map.mapValues { it ->
        var a = INT_INF
        var b = 0
        for (i in it.value) {
            a = min(a, y[i])
            b = max(b, y[i])
        }
        a to b
    }
    _debug_println(map2)
    var cx = ax
    var cy1 = ay
    var cy2 = ay
    var ans = sizedLongArray(2, 0)
    map2.entries.sortedBy { it.key }.forEach { (nx, v) ->
        val (ny1, ny2) = v
        var pre = sizedLongArray(2, 0)
        ans = pre.also { pre = ans }
        // y1
        ans[0] = min(
            (nx - cx) + abs(ny2 - cy1) + pre[0],
            (nx - cx) + abs(ny2 - cy2) + pre[1]
        ) + abs(ny1 - ny2)
        ans[1] = min(
            (nx - cx) + abs(ny1 - cy1) + pre[0],
            (nx - cx) + abs(ny1 - cy2) + pre[1]
        ) + abs(ny1 - ny2)
        cx = nx
        cy1 = ny1
        cy2 = ny2
        _debug_println(ans)
    }
    println(ans.min())
}
