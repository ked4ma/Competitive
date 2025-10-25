package com.github.ked4ma.competitive.atcoder.abc428

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    // NOTE: double sweep (tree's diameter)
    //         exec dfs twice
    val N = nextInt()
    val G = sizedArray(N) { mutableListOf<Int>() }
    repeat(N - 1) {
        val (A, B) = nextIntList().map { it - 1 }
        G[A].add(B)
        G[B].add(A)
    }

    // WARNING: TLE in kotlin
    val ans = sizedArray(N) { 0 to -1 }
    fun dfs(s: Int, u: Int, p: Int = -1, d: Int = 0): Pair<Int, Int> {
        ans[u] = maxOf(ans[u], s to d, compareBy({ it.second }, { it.first }))
        var res = u to d
        for (v in G[u]) {
            if (v == p) continue
            res = maxOf(res, dfs(s, v, u, d + 1), compareBy({ it.second }, { it.first }))
        }
        return res
    }

    val a = dfs(0, 0).first
    val b = dfs(a, a).first
    dfs(b, b)

    println((0 until N).map { ans[it].first + 1 }.joinToString("\n"))
}


// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
//fun main() {
//    val N = nextInt()
//    val G = sizedArray(N) { mutableListOf<Int>() }
//    repeat(N - 1) {
//        val (A, B) = nextIntList().map { it - 1 }
//        G[A].add(B)
//        G[B].add(A)
//    }
//
//    fun ins(arr: Array<IntArray>, d: Int, n: Int, v: Int) {
//        var a = d
//        var b = n
//        var c = v
//        if (arr[0][0] < a) {
//            val a0 = arr[0][0]
//            val b0 = arr[0][1]
//            val c0 = arr[0][2]
//            arr[0][0] = a
//            arr[0][1] = b
//            arr[0][2] = c
//            a = a0
//            b = b0
//            c = c0
//        } else if (arr[0][0] == a) {
//            if (arr[0][1] < b) {
//                val a0 = arr[0][0]
//                val b0 = arr[0][1]
//                val c0 = arr[0][2]
//                arr[0][0] = a
//                arr[0][1] = b
//                arr[0][2] = c
//                a = a0
//                b = b0
//                c = c0
//            }
//        }
//        if (arr[1][0] < a) {
//            arr[1][0] = a
//            arr[1][1] = b
//            arr[1][2] = c
//        } else if (arr[1][0] == a) {
//            if (arr[1][1] < b) {
//                arr[1][0] = a
//                arr[1][1] = b
//                arr[1][2] = c
//            }
//        }
//    }
//
//    val dist = sized3DIntArray(N, 2, 3, -1)
//    run {
//        val stack = Stack<Triple<Int, Int, Boolean>>()
//        stack.push(Triple(0, -1, true))
//        while (stack.isNotEmpty()) {
//            val (u, p, isPre) = stack.pop()
//            if (isPre) {
//                stack.push(Triple(u, p, false))
//                for (v in G[u]) {
//                    if (v == p) continue
//                    stack.push(Triple(v, u, true))
//                }
//            } else {
//                dist[u][0][0] = 0
//                dist[u][0][1] = u
//                dist[u][0][2] = u
//                for (v in G[u]) {
//                    if (v == p) continue
//                    ins(dist[u], dist[v][0][0] + 1, dist[v][0][1], v)
//                }
//                _debug_println("---")
//                _debug_println(u)
//                _debug_println(dist[u])
//            }
//        }
//    }
//
//    val ans = sizedIntArray(N, 0)
//    run {
//        data class Data(val u: Int, val p: Int, val pd: Int, val pn: Int)
//
//        val stack = Stack<Data>()
//        stack.push(Data(0, -1, -1, -1))
//        while (stack.isNotEmpty()) {
//            val (u, p, pd, pn) = stack.pop()
//            _debug_println("===")
//            _debug_println(dist[u])
//            var (v1, v2, _) = dist[u][0]
//            if (v1 < pd + 1) {
//                v1 = pd + 1
//                v2 = pn
//            } else if (v1 == pd + 1) {
//                v2 = max(v2, pn)
//            }
//            ans[u] = v2 + 1
//            val arr = dist[u].copyOf()
//            if (p >= 0) {
//                ins(arr, pd + 1, pn, p)
//            }
//
//            for (v in G[u]) {
//                if (v == p) continue
//                val (npd, npn, _) = if (arr[0][2] == v) arr[1] else arr[0]
//                stack.push(Data(v, u, npd, npn))
//            }
//        }
//    }
//
//    println(ans.joinToString("\n"))
//}
//
