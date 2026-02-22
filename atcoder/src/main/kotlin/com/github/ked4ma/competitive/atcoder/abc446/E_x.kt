package com.github.ked4ma.competitive.atcoder.abc446

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.boolean.d1.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (M, A, B) = nextIntList()
    val n = M * M
    val G = sizedArray(n) { mutableListOf<Int>() }
    for (i in 0 until M) {
        for (j in 0 until M) {
            val k = (j * A + i * B) % M
            // (i, j) -> (j, k)
            val u = i * M + j
            val v = j * M + k
            // add edges as reverse
            G[v].add(u)
        }
    }
    val used = sizedBooleanArray(n)
    val queue = ArrayDeque<Int>()
    fun push(u: Int) {
        if (used[u]) return
        used[u] = true
        queue.add(u)
    }
    for (i in 0 until M) {
        push(i)
        push(i * M)
    }
    while (queue.isNotEmpty()) {
        val u = queue.removeFirst()
        for (v in G[u]) push(v)
    }
    println(used.count { !it })
}
