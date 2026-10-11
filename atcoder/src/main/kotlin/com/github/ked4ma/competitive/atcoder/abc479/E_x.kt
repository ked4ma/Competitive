package com.github.ked4ma.competitive.atcoder.abc479

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.array.long.output.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()

    data class D(val v: Int, val e: Long)

    val G = sizedArray(N) {
        mutableListOf<D>()
    }
    repeat(N - 1) { i ->
        val (A, B) = nextIntList()
        G[A - 1].add(D(B - 1, i + 1L))
        G[B - 1].add(D(A - 1, i + 1L))
    }
    val inA = sizedIntArray(N)
    val outA = sizedIntArray(N)
    var tour = 0
    val size = sizedIntArray(N)
    fun dfs(u: Int = 0, p: Int = -1) {
        inA[u] = tour
        tour++
        for ((v, _) in G[u]) {
            if (v == p) continue
            dfs(v, u)
            size[u] += size[v]
        }
        outA[u] = tour
        size[u]++
    }
    dfs()
    val arr = sizedLongArray(N + 1)
    fun dfs2(u: Int = 0, p: Int = -1) {
        for ((v, e) in G[u]) {
            if (v == p) continue
            val l = inA[v]
            val r = outA[v]
            val s = size[v]
            if (s < N - s) {
                arr[0] += e
                arr[N] -= e
                arr[l] += -e
                arr[r] += e
            } else {
                arr[l] += e
                arr[r] += -e
            }
            _debug_println("$v ${size[v]}")
            dfs2(v, u)
        }
    }
    dfs2()
    for (i in 0 until N) {
        arr[i + 1] += arr[i]
    }
    val ans = sizedLongArray(N)
    for (i in 0 until N) {
        ans[i] = arr[inA[i]]
    }
    ans.println(" ")
}
// fun main() {
//     val N = nextInt()
//
//     data class D(val v: Int, val e: Long)
//
//     val G = sizedArray(N) {
//         mutableListOf<D>()
//     }
//     repeat(N - 1) { i ->
//         val (A, B) = nextIntList()
//         G[A - 1].add(D(B - 1, i + 1L))
//         G[B - 1].add(D(A - 1, i + 1L))
//     }
//     val arr = sizedLongArray(N)
//     fun dfs(u: Int = 0, p: Int = -1): Int {
//         var size = 1
//         for ((v, e) in G[u]) {
//             if (v == p) continue
//             val s = dfs(v, u)
//             if (s < N - s) {
//                 arr[0] += e
//                 arr[v] -= e
//             } else {
//                 arr[v] += e
//             }
//             size += s
//         }
//
//         return size
//     }
//     dfs()
//     val ans = sizedLongArray(N)
//     fun dfs2(u: Int = 0, p: Int = -1, x: Long = arr[u]) {
//         ans[u] = x
//         for ((v, _) in G[u]) {
//             if (v == p) continue
//             dfs2(v, u, x + arr[v])
//         }
//     }
//     dfs2()
//     ans.println(" ")
// }
