package com.github.ked4ma.competitive.atcoder.abc459

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.tree.fenwick.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    var min = 0
    val cnt = sizedIntArray(N)
    val ft = FenwickTree(Q + 1)
    ft.add(0, N.toLong())
    repeat(Q) {
        val (t, x) = nextIntList()
        when (t) {
            1 -> {
                val i = x - 1
                ft.add(cnt[i], -1)
                cnt[i]++
                ft.add(cnt[i], 1)
                while (ft.sum(min, min + 1) == 0L) min++
            }

            2 -> {
                val y = x + min
                if (y > Q + 1) {
                    println(0)
                    return@repeat
                }
                println(ft.sum(y))
            }
        }
    }
}
