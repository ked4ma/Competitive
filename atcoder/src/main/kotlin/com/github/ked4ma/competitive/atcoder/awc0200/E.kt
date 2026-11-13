package com.github.ked4ma.competitive.atcoder.awc0200

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.array.long.output.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val S = nextLongList()
    val PR = times(M) {
        val (P, R) = nextLongList()
        P to R.toInt()
    }.withIndex().sortedWith(compareBy({ -it.value.first }, { it.index }))

    val q = PriorityQueue<Long>(reverseOrder())
    q.addAll(S)

    val ans = sizedLongArray(M)
    for ((i, pr) in PR) {
        val (p, r) = pr
        if (q.size < r) {
            println(-1)
            return
        }
        var x = 0L
        repeat(r) {
            x += q.poll()
        }
        ans[i] = x
    }

    ans.println("\n")
}
