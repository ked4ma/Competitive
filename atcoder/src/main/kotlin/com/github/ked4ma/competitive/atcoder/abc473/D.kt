package com.github.ked4ma.competitive.atcoder.abc473

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.array.int.output.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextIntList()
    val ans = sizedIntArray(N)
    fun f(i: Int = 0, k: Int = 0) {
        if (i == N - 1) {
            if ((K - k) % N == 0) {
                ans[i] = (K - k) / N
                ans.println(" ")
            }
            return
        }
        val j = i + 1
        for (x in 0..K - k step j) {
            ans[i] = x / j
            f(i + 1, k + x)
        }
    }
    f()
}
// fun main() {
//     val (N, K) = nextIntList()
//     val memo = sizedArray(N) { mutableMapOf<Int, List<String>>() }
//     for (i in 0..K) {
//         if (i % N == 0) {
//             memo[N - 1][i] = listOf("${i / N}")
//         } else {
//             memo[N - 1][i] = emptyList()
//         }
//     }
//     fun f(i: Int = 0, k: Int = K): List<String> {
//         if (i == N) {
//             if (k != 0) return emptyList()
//             return listOf("")
//         }
//         if (k in memo[i]) return memo[i].getValue(k)
//         val list = mutableListOf<String>()
//         val j = i + 1
//         for (x in 0..k step j) {
//             val l = f(i + 1, k - x)
//             if (l.isEmpty()) continue
//             for (s in l) {
//                 list.add("${x / j} $s")
//             }
//         }
//         memo[i][k] = list
//         return list
//     }
//     f()
//     println(memo[0].getValue(K).joinToString("\n") { it.trim() })
// }
