package com.github.ked4ma.competitive.codeforces.`2173`

import com.github.ked4ma.competitive.common.array.boolean.d1.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    var (n, k) = nextIntList()
    val a = nextIntList().sorted().distinct()
    n = a.size
    val aMap = a.withIndex().associate { it.value to it.index }
    val vis = sizedBooleanArray(n)
    val b = mutableSetOf<Int>()
    for (i in a) {
        if (vis[aMap.getValue(i)]) continue
        var j = i
        while (j <= k) {
            if (j in aMap) {
                vis[aMap.getValue(j)] = true
            } else {
                break
            }
            j += i
        }
        if (j <= k) {
            println(-1)
            return
        }
        b.add(i)
    }
    println(b.size)
    println(b.sorted().joinToString(" "))
}
