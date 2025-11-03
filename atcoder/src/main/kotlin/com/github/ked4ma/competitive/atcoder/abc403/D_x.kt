package com.github.ked4ma.competitive.atcoder.abc403

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.array.int.d2.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.range.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val M = 1000001
    val (N, D) = nextIntList()
    val A = nextIntList()
    val cnt = sizedIntArray(M, 0)
    for (a in A) cnt[a]++

    var ans = 0
    if (D == 0) {
        for (n in cnt) {
            if (n > 0) ans++
        }
    } else {
        for (d in range(D)) {
            val list = mutableListOf<Int>()
            run {
                var i = d
                while (i < M) {
                    list.add(cnt[i])
                    i += D
                }
            }
            val dp = sized2DIntArray(list.size + 1, 2, 0)
            for (i in range(list.size)) {
                dp[i + 1][0] = dp[i][1] + list[i]
                dp[i + 1][1] = dp[i].max()
            }
            ans += dp.last().max()
        }
    }
    println(N - ans)
}
