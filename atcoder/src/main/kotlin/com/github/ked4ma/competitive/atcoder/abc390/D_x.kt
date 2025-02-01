package com.github.ked4ma.competitive.atcoder.abc390

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextLongList().toLongArray()
//    val N = 12
//    val A = sizedLongArray(N) { it + 1L }
    val ans = mutableSetOf<Long>()
    val arr = sizedLongArray(N, 0)
    arr[0] = A[0]
    var m = arr[0]
    fun dfs(i: Int = 1, k: Int = 1) {
        if (i == N) {
            ans.add(m)
            return
        }
        for (j in range((k + 1).coerceAtMost(N))) {
            m = m xor arr[j]
            arr[j] += A[i]
            m = m xor arr[j]

            if (j == k) {
                dfs(i + 1, k + 1)
            } else {
                dfs(i + 1, k)
            }

            m = m xor arr[j]
            arr[j] -= A[i]
            m = m xor arr[j]
        }
    }
    dfs()
    _debug_println(ans)
    println(ans.size)
}
