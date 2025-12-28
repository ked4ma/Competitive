package com.github.ked4ma.competitive.codeforces.`2178`

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    val (n, m) = nextIntList()
    val a = nextLongList().withIndex().sortedBy { it.value }
    if (2 * m > n) {
        println(-1)
        return
    }
    val ans = mutableListOf<Pair<Int, Int>>()
    if (m > 0) {
        val s = n - 2 * m
        for (i in 0 until s) {
            ans.add(a[i].index to a[i + 1].index)
        }
        for (i in n - m until n) {
            ans.add(a[i].index to a[i - m].index)
        }
    } else {
        _debug_println("input: $n $m")
        val i = run {
            var i = n - 2
            var sum = 0L
            while (i >= 0) {
                sum += a[i].value
                if (sum >= a.last().value) break
                i--
            }
            i
        }
        if (i < 0) {
            println(-1)
            return
        }
        for (j in 0 until i) {
            ans.add(a[j].index to a[j + 1].index)
        }
        for (j in i until n - 1) {
            ans.add(a[j].index to a.last().index)
        }
    }
    println(ans.size)
    println(ans.joinToString("\n") { "${it.first + 1} ${it.second + 1}" })
}
