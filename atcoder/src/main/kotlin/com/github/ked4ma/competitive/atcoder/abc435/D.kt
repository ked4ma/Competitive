package com.github.ked4ma.competitive.atcoder.abc435

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.debug._debug_println
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val G = sizedArray(N) { mutableListOf<Int>() }
    val achievable = mutableSetOf<Int>()
    repeat(M) {
        val (X, Y) = nextIntList().map { it - 1 }
        G[Y].add(X)
    }
    val Q = nextInt()
    repeat(Q) {
        val (t, u) = nextIntList().let { (t, u) -> t to u - 1 }
        when (t) {
            1 -> {
                if (u in achievable) return@repeat
                val queue = ArrayDeque<Int>()
                queue.add(u)
                achievable.add(u)
                while (queue.isNotEmpty()) {
                    val i = queue.removeFirst()
                    for (j in G[i]) {
                        if (j in achievable) continue
                        queue.add(j)
                        achievable.add(j)
                    }
                }
            }

            2 -> {
                _debug_println(achievable.map { it + 1 })
                println(if (u in achievable) "Yes" else "No")
            }
        }
    }
}
