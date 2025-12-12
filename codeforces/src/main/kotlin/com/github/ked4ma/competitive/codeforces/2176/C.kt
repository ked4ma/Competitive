package com.github.ked4ma.competitive.codeforces.`2176`

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.long.cumlative.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    val n = nextInt()
    val a = nextLongList()
    val odd = a.filter { it % 2 == 1L }.sorted()
    val even = a.filter { it % 2 == 0L }.sortedDescending()

    if (odd.isEmpty()) {
        println(times(n) { 0 }.joinToString(" "))
        return
    }
    // |odd| >= 1
    val evenCum = even.cumulativeSum()
    val ans = sizedLongArray(n, 0)
    ans[0] = odd.last()
    var i = odd.lastIndex
    var j = i + 1
    for (k in 1 until n) {
        _debug_println("$i $j ${odd.size} ${even.size}")
        if (j < odd.size + even.size) {
            j++
        } else if (even.isEmpty()) {
            i--
        } else if (i == 1) {
            i--
        } else {
            i -= 2
            j--
        }
        _debug_println("$i $j ${odd.size} ${even.size}")
        ans[k] = ((odd.size - i) % 2) * (odd.last()
                + evenCum[(j - odd.size).coerceAtLeast(0)])
    }

    println(ans.joinToString(" "))
}
