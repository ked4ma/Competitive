package com.github.ked4ma.competitive.codeforces.`2088`

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    val (n, m) = nextIntList()
    val p = times(n) {
        nextIntList().sorted()
    }.withIndex().sortedBy { it.value[0] }
    val indices = sizedIntArray(n, 0)

    var ans = mutableListOf<Int>()
    val queue = ArrayDeque<Int>()
    queue.addAll(range(n))
    var top = -1
    while (queue.isNotEmpty()) {
        val i = queue.removeFirst()
        while (indices[i] < m && p[i].value[indices[i]] <= top) indices[i]++
        if (indices[i] >= m) continue
        top = p[i].value[indices[i]]
        indices[i]++
        if (indices[i] >= m) {
            ans.add(p[i].index + 1)
            continue
        }
        queue.addLast(i)
    }
    println(if (ans.size == n) ans.joinToString(" ") else -1)
}
