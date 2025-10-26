package com.github.ked4ma.competitive.atcoder.abc429

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.long.cumlative.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M, C) = nextLongList()
    val A = nextLongList()

    val map = A.groupingBy { it }.eachCount().toSortedMap()
    if (0 !in map) map[0] = 0
    val keys = map.keys.sorted()
    val vSum = map.values.map { it.toLong() }.let { it + it + it }.cumulativeSum()
    _debug_println(vSum)
    fun xi(i: Int): Long {
        var l = i + 1
        var r = vSum.size
        while (l + 1 < r) {
            val m = (l + r) / 2
            if (vSum[m] - vSum[i + 1] < C) {
                l = m
            } else {
                r = m
            }
        }
        return vSum[r] - vSum[i + 1]
    }
    _debug_println(map)
    var i = 0
    var iValue = 0L

    var ans = 0L
    while (i < keys.size) {
        val niValue = if (i + 1 < keys.size) keys[i + 1] else M
        val cnt = xi(i)
        _debug_println(cnt)
        ans += cnt * (niValue - iValue)

        i++
        iValue = niValue
    }
    println(ans)
}
