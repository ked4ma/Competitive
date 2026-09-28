package com.github.ked4ma.competitive.atcoder.awc0166

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.long.bound.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M, K) = nextIntList()
    val S = nextLongList()
    val G = nextLongList().sorted()
    val cnt = sizedIntArray(M)
    var ans = 0
    for (s in S) {
        val i = G.upperBound(s) - 1
        if (i in 0 until M && cnt[i] < K) {
            cnt[i]++
            ans++
        }
    }
    println(ans)
}
