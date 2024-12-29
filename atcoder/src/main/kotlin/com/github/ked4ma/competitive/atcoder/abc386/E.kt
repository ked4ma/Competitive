package com.github.ked4ma.competitive.atcoder.abc386

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextIntList()
    val A = nextLongList()
    var ans = 0L
    fun dfs(i: Int, k: Int, c: Long) {
        if (k == 0) {
            ans = max(ans, c)
            return
        }
        if (i == N) return
        dfs(i + 1, k, c) // not used
        dfs(i + 1, k - 1, c xor A[i]) // used
    }
    if (K <= N - K) {
        dfs(0, K, 0)
    } else {
        val allXor = A.fold(0L) { acc, c -> acc xor c }
        dfs(0, N - K, allXor)
    }
    println(ans)
    // val arr = sizedLongArray(N + 1, 0)
    // for (k in (N - K until N).reversed()) {
    //     arr[k] = arr[k + 1] xor A[k]
    // }
    // var ans = 0L
    // fun dfs(i: Int = 0, s: Int = 0, c: Long = 0) {
    //     if (s + K - (i + 1) + 1 == N) {
    //         ans = max(ans, c xor arr[s])
    //         return
    //     } else if (i == K) {
    //         ans = max(ans, c)
    //         return
    //     }
    //     for (j in s until N - (K - (i + 1))) {
    //         dfs(i + 1, j + 1, c xor A[j])
    //     }
    // }
    // dfs()
    // println(ans)
}
