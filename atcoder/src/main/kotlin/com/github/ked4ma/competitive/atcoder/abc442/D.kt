package com.github.ked4ma.competitive.atcoder.abc442

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.tree.fenwick.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val A = nextLongList().toLongArray()
    val ft = FenwickTree(N)
    for (i in 0 until N) {
        ft.add(i, A[i])
    }
    repeat(Q) {
        val query = nextIntList()
        when (query[0]) {
            1 -> {
                val x = query[1] - 1
                val d = A[x + 1] - A[x]
                ft.add(x, d)
                ft.add(x + 1, -d)
                A[x] = A[x + 1].apply { A[x + 1] = A[x] }
            }

            2 -> {
                val l = query[1] - 1
                val r = query[2]
                println(ft.sum(l, r))
            }
        }
    }
}
