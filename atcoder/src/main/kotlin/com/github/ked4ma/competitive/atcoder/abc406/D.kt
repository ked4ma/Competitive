package com.github.ked4ma.competitive.atcoder.abc406

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W, N) = nextIntList()
    val row = sizedArray(H) { mutableSetOf<Int>() }
    val col = sizedArray(W) { mutableSetOf<Int>() }
    repeat(N) {
        val (X, Y) = nextIntList().map { it - 1 }
        row[X].add(Y)
        col[Y].add(X)
    }

    val ans = mutableListOf<Int>()
    val Q = nextInt()
    repeat(Q) {
        val (op, i) = nextIntList()
        when (op) {
            1 -> {
                ans.add(row[i - 1].size)
                for (y in row[i - 1]) {
                    col[y].remove(i - 1)
                }
                row[i - 1].clear()
            }

            2 -> {
                ans.add(col[i - 1].size)
                for (x in col[i - 1]) {
                    row[x].remove(i - 1)
                }
                col[i - 1].clear()
            }
        }
    }
    println(ans.joinToString("\n"))
}
