package com.github.ked4ma.competitive.atcoder.abc427

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.max
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    val (N, M, K) = nextIntList()
    val S = nextCharArray()
    val revG = sizedArray(N) { mutableListOf<Int>() }
    repeat(M) {
        val (u, v) = nextIntList().map { it - 1 }
        revG[v].add(u)
    }
    var dp = sizedIntArray(N, 0)
    for (i in 0 until N) {
        dp[i] = if (S[i] == 'A') 0 else 1
    }
    for (i in 0 until 2 * K) {
        val next: IntArray
        if (i % 2 == 0) { // bob
            next = sizedIntArray(N, 0)
            for (u in 0 until N) {
                for (v in revG[u]) {
                    next[v] = max(next[v], dp[u])
                }
            }
        } else { // alice
            next = sizedIntArray(N, 1)
            for (u in 0 until N) {
                for (v in revG[u]) {
                    next[v] = min(next[v], dp[u])
                }
            }
        }
        dp = next
        _debug_println(S.joinToString("") == "ABAB") { dp }
    }
    println(if (dp[0] == 0) "Alice" else "Bob")
}
