package com.github.ked4ma.competitive.atcoder.abc466

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.array.int.d1.chmax.*
import com.github.ked4ma.competitive.common.array.int.output.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val ans = sizedIntArray(M, -1)
    repeat(N) {
        val (c, s) = nextIntList()
        ans.chmax(c - 1, s)
    }
    ans.println(" ")
}
