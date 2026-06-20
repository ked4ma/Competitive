package com.github.ked4ma.competitive.atcoder.arc222

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.array.long.output.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.set.multi.*
import java.util.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    val (N, M) = nextIntList()
    val lSet = MultiSet<Int>()

    data class D(val l: Int, val r: Int, val isL: Boolean) {
        val v: Int = if (isL) l else r
    }

    val queue = PriorityQueue<D>(compareBy { it.v })
    var x = 0
    repeat(M) {
        val (L, R) = nextIntList()
        queue.offer(D(L - 1, R, true))
        queue.offer(D(L - 1, R, false))
        x = max(x, R - L + 1)
    }
    val stock = PriorityQueue<Long>()
    repeat(x) { stock.offer(it + 1L) }

    val ans = sizedLongArray(N)
    for (i in 0 until N) {
        val preL = if (lSet.isEmpty()) i else lSet.first()
        while (queue.isNotEmpty() && queue.peek().v == i) {
            val d = queue.poll()
            if (d.isL) {
                lSet.add(d.l)
            } else {
                lSet.remove(d.l)
            }
        }
        val curL = if (lSet.isEmpty()) i else lSet.first()
        for (j in preL until curL) {
            stock.offer(ans[j])
        }
        if (lSet.isEmpty()) {
            ans[i] = 1
        } else {
            val l = lSet.first()
            ans[i] = stock.poll()
        }
    }

    ans.println(" ")
}
