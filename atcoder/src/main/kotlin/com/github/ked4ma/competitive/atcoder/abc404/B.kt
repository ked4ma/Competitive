package com.github.ked4ma.competitive.atcoder.abc404

import com.github.ked4ma.competitive.common.array.char.d2.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import com.github.ked4ma.competitive.common.repeat.range.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    var S = times(N) { nextCharArray() }.toTypedArray()
    val T = times(N) { nextCharArray() }.toTypedArray()
    var ans = Int.MAX_VALUE
    repeat(4) { k ->
        var cnt = 0
        for (i in range(N)) {
            for (j in range(N)) {
                if (S[i][j] != T[i][j]) cnt++
            }
        }
        ans = min(ans, cnt + (k % 4))
        val next = sized2DCharArray(N, N, ' ')
        for (i in range(N)) {
            for (j in range(N)) {
                next[j][N - 1 - i] = S[i][j]
            }
        }
        S = next
    }
    println(ans)
}
