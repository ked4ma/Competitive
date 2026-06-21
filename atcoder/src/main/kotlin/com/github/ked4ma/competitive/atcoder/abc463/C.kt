package com.github.ked4ma.competitive.atcoder.abc463

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.array.int.output.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val HL = times(N) {
        val (H, L) = nextIntList()
        H to L
    }.sortedByDescending { it.second }
    val Q = nextInt()
    val T = nextIntList().withIndex().sortedByDescending { it.value }
    val ans = sizedIntArray(Q)
    var h = 0
    var i = 0
    for ((j, t) in T) {
        while (i < N && HL[i].second > t) {
            h = max(h, HL[i].first)
            i++
        }
        ans[j] = h
    }
    ans.println("\n")
}
