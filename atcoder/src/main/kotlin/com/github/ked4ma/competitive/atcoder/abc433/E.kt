package com.github.ked4ma.competitive.atcoder.abc433

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.int.d2.*
import com.github.ked4ma.competitive.common.input.default.*
import java.util.*
import kotlin.math.abs
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private data class Data(val i: Int, val j: Int, val grace: Int)

private fun solve() {
    val (N, M) = nextIntList()
    val X = nextIntList()
    val Y = nextIntList()

    if (X.toSet().size < N || Y.toSet().size < M) {
        println("No")
        return
    }

    val queue = sizedArray(N * M + 1) { PriorityQueue<Data>(compareBy { it.grace }) }
    for (i in 0 until N) {
        for (j in 0 until M) {
            queue[min(X[i], Y[j])].offer(Data(i, j, abs(X[i] - Y[j])))
        }
    }

    val free = ArrayDeque<Data>()
    val ans = sized2DIntArray(N, M, 0)
    for (x in (1..N * M).reversed()) {
        if (queue[x].isEmpty() && free.isEmpty()) {
            println("No")
            return
        }
        if (queue[x].isNotEmpty()) {
            val (i, j, _) = queue[x].poll()
            ans[i][j] = x
            free.addAll(queue[x])
        } else {
            val (i, j, _) = free.poll()
            ans[i][j] = x
        }
    }
    println("Yes")
    println(ans.joinToString("\n") { it.joinToString(" ") })
}
