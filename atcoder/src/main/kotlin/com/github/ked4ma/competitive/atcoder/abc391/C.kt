package com.github.ked4ma.competitive.atcoder.abc391

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val P = sizedIntArray(N + 1) { it }
    val H = sizedIntArray(N + 1, 1)
    var ans = 0

    repeat(Q) {
        val q = nextIntList()
        when (q[0]) {
            1 -> {
                val p = q[1]
                val h = q[2]
                H[P[p]]--
                if (H[P[p]] == 1) ans--
                H[h]++
                if (H[h] == 2) ans++
                P[p] = h
            }

            2 -> {
                println(ans)
            }
        }
    }
}
