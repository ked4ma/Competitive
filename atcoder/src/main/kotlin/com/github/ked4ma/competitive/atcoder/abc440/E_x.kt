package com.github.ked4ma.competitive.atcoder.abc440

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.array.long.output.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.long.output.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K, X) = nextIntList()
    val A = nextLongList().sortedDescending()
    val queue = PriorityQueue<Pair<Long, List<Int>>>(compareByDescending { it.first })
    queue.offer(A[0] * K to buildList {
        add(K)
        repeat(N - 1) { add(0) }
    })
    val ans = mutableListOf<Long>()
    while (ans.size < X) {
        val (n, l) = queue.poll()
        ans.add(n)
        var i = N - 1
        while (l[i] == 0) i--
        if (i < N - 1) {
            val nl = l.toMutableList()
            nl[i]--
            nl[i + 1]++
            queue.offer(n - A[i] + A[i + 1] to nl.toList())
        }
        if (i >= 1 && l[i - 1] > 0) {
            val nl = l.toMutableList()
            nl[i - 1]--
            nl[i]++
            queue.offer(n - A[i - 1] + A[i] to nl.toList())
        }
    }
    // val vis = mutableSetOf<List<Int>>()
    // repeat(X) {
    //     val (n, l) = queue.poll()
    //     ans.add(n)
    //     for (i in 0 until N - 1) {
    //         if (l[i] == 0) continue
    //         val nl = l.toMutableList()
    //         nl[i]--
    //         nl[i + 1]++
    //         if (nl in vis) continue
    //         vis.add(nl)
    //         queue.offer(n - A[i] + A[i + 1] to nl.toList())
    //     }
    // }
    ans.println("\n")
}
