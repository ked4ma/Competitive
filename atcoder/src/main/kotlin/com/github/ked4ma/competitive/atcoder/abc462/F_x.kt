package com.github.ked4ma.competitive.atcoder.abc462

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.array.int.d2.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    val S = nextCharArray()
    val K = nextInt()
    val n = S.size
    var dp = ArrayDeque(
        sized2DIntArray(K + 2, 3, INT_INF).toList()
    )
    dp[0][0] = 0
    for (i in 0 until n) {
        var pre = ArrayDeque(
            sized2DIntArray(K + 2, 3, INT_INF).toList()
        )
        dp = pre.also { pre = dp }
        for (j in 0 until K + 2) {
            for (a in 0 until 3) {
                for (cc in "ABC?") { // next char (? = not to change)
                    var c = cc
                    var now = pre[j][a]
                    if (c != '?') now++ // if change 'A' to 'A', treat as CHANGED (cost +1)
                    if (c == '?') c = S[i]
                    var nj = j
                    var na = a
                    if ("ABC"[a] == c) na++
                    else if (c == 'A') na = 1
                    else na = 0
                    if (na == 3) {
                        na = 0
                        nj++
                    }
                    if (nj > K + 1) continue
                    dp.chmin(nj, na, now)
                }
            }
        }
        if (i >= 2 && S[i - 2] == 'A' && S[i - 1] == 'B' && S[i] == 'C') {
            dp.removeFirst()
            dp.addLast(sizedIntArray(3, INT_INF))
        }
    }
    var ans = dp[K].min()
    if (ans == INT_INF) ans = -1
    println(ans)
}

private inline fun ArrayDeque<IntArray>.chmin(i: Int, j: Int, v: Int) {
    if (this[i][j] > v) this[i][j] = v
}
