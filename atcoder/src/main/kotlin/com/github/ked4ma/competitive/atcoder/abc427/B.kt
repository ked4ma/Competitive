package com.github.ked4ma.competitive.atcoder.abc427

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val memo = sizedIntArray(N + 1, -1)
    memo[1] = 1
    fun f(n: Int): Int {
        var m = n
        var res = 0
        while (m > 0) {
            res += m % 10
            m /= 10
        }
        return res
    }

    fun dfs(n: Int): Int {
        if (memo[n] < 0) {
            memo[n] = dfs(n - 1) + f(memo[n - 1])
        }
        return memo[n]
    }
    println(dfs(N))
}
