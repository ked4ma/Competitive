package com.github.ked4ma.competitive.atcoder.abc459

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    val S = next()
    val n = S.length
    val cnt = S.groupingBy { it }.eachCount()
    val max = cnt.values.max()
    val rem = n - max
    if (max - 1 > rem) {
        println("No")
        return
    }
    val list = cnt.entries.sortedByDescending { it.value }
    val M = list[0].value
    val queue = sizedArray(M) { mutableListOf<Char>() }
    var i = 0
    for (j in 1 until list.size) {
        val (c, m) = list[j]
        repeat(m) {
            queue[i].add(c)
            i = (i + 1) % M
        }
    }
    val ans = StringBuilder()
    val c = list[0].key
    for (q in queue) {
        ans.append(c)
        ans.append(q.joinToString(""))
    }
    println("Yes")
    println(ans)
}
