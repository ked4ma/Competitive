package com.github.ked4ma.competitive.atcoder.abc410

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val X = nextIntList()
    val cnt = sizedIntArray(N, 0)
    val ans = sizedIntArray(Q, 0)
    for (i in range(Q)) {
        val x = X[i]
        if (x > 0) {
            cnt[x - 1]++
            ans[i] = x
            continue
        }
        var index = 0
        var c = Int.MAX_VALUE
        for (j in range(N)) {
            if (c > cnt[j]) {
                c = cnt[j]
                index = j
            }
        }
        cnt[index]++
        ans[i] = index + 1
    }
    println(ans.joinToString(" "))
}
