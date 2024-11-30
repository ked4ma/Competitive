package com.github.ked4ma.competitive.atcoder.abc382

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val memo = mutableMapOf<Pair<Int, Int>, List<String>>()
    fun dfs(i: Int = 0, start: Int = 1): List<String> {
        if (i == N) {
            return listOf("")
        }
        if (i to start in memo) {
            return memo.getValue(i to start)
        }
        val res = buildList {
            for (j in start..(M - 10 * (N - i - 1))) {
                val next = dfs(i + 1, j + 10)
                next.forEach {
                    add("$j $it".trim())
                }
            }
        }
        memo[i to start] = res
        return res
    }

    val ans = dfs()
    println(ans.size)
    println(ans.joinToString("\n"))
}
