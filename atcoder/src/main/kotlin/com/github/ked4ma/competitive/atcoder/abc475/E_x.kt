package com.github.ked4ma.competitive.atcoder.abc475

import com.github.ked4ma.competitive.common.boolean.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M, K) = nextIntList()
    val T = nextCharArray()
    val S = times(N) {
        nextCharArray().mapIndexed { i, c ->
            if (c == T[i]) 0 else 1
        }.toIntArray()
    }

    val t = Trie()
    for (a in S) {
        t.add(a)
    }

    val Q = nextInt()
    repeat(Q) {
        val (i, j) = nextIntList().map { it - 1 }
        t.add(S[i], -1)
        S[i][j] = 1 - S[i][j]
        t.add(S[i])
        println(t.judge(S[i], M).toYesNo())
    }
}

private class Trie {
    class Node {
        var l: Int = -1
        var r: Int = -1
        var c: Int = 0
    }

    val d = mutableListOf(Node())

    fun get(v: Int, x: Int) = if (x == 0) {
        if (d[v].l == -1) {
            d[v].l = d.size
            d.add(Node())
        }
        d[v].l
    } else {
        if (d[v].r == -1) {
            d[v].r = d.size
            d.add(Node())
        }
        d[v].r
    }

    fun add(a: IntArray, sg: Int = 1) {
        var v = 0
        d[v].c += sg
        for (x in a) {
            v = get(v, x)
            d[v].c += sg
        }
    }

    fun judge(a: IntArray, M: Int): Boolean {
        var v = 0
        var m = M
        for (x in a) {
            val l = get(v, 0)
            val r = get(v, 1)
            if (d[l].c <= m) {
                if (x == 0) return true
                m -= d[l].c
                v = r
            } else {
                if (x == 1) return false
                v = l
            }
        }
        return false
    }
}
// fun main() {
//     val (N, M, K) = nextIntList()
//     val T = nextCharArray()
//     val S = times(N) {
//         val s = nextCharArray()
//         for (i in 0 until K) {
//             s[i] = if (s[i] == T[i]) '0' else '1'
//         }
//         s
//     }
//     val Q = nextInt()
//
//     val q = MultiSet<String>(reverseOrder())
//     val q2 = MultiSet<String>()
//     fun addQueue(s: String) {
//         q.add(s)
//         while (q.size > M) {
//             val e = q.first()
//             q.remove(e)
//             q2.add(e)
//         }
//     }
//
//     fun removeQueue(s: String) {
//         if (q.count(s) > 0) {
//             q.remove(s)
//         } else if (q2.count(s) > 0) {
//             q2.remove(s)
//         }
//         while (q.size < M && q2.isNotEmpty()) {
//             val e = q2.first()
//             q.add(e)
//             q2.remove(e)
//         }
//     }
//     for (s in S) {
//         addQueue(s.concatToString())
//     }
//
//     repeat(Q) {
//         val (i, j) = nextIntList().map { it - 1 }
//         removeQueue(S[i].concatToString())
//         S[i][j] = if (S[i][j] == '1') '0' else '1'
//         val s = S[i].concatToString()
//         if (s.all { it == '1' }) {
//             println("No")
//             return@repeat
//         }
//         addQueue(s)
//         val b1 = q.count(s) > 0
//         val b2 = q2.count(s) > 0
//         println((b1 && !b2).toYesNo())
//     }
// }
// fun main() {
//     val (N, M, K) = nextIntList()
//     val T = nextCharArray()
//     val S = times(N) { nextCharArray() }
//     val Q = nextInt()
//
//     val stat = sized2DArray(K, 2) { mutableSetOf<Int>() }
//     for (n in 0 until N) {
//         for (k in 0 until K) {
//             when (S[n][k] == T[k]) {
//                 true -> stat[k][0].add(n)
//                 false -> stat[k][1].add(n)
//             }
//         }
//     }
//
//     data class R(val ok: Set<Int> = emptySet(), val ng: Set<Int> = emptySet())
//
//     val arr = sizedArray(K + 1) { R() }
//     for (k in 0 until K) {
//         var (o: Set<Int>, n: Set<Int>) = stat[k]
//         val (l, r) = arr[k]
//         o = o - l - r
//         n = n - l - r
//         arr[k + 1] = if (o.size + l.size <= K) {
//             R(l + o, r)
//         } else {
//             R(l, r + n)
//         }
//     }
//
//     var com = K
//     repeat(Q) {
//         val (i, j) = nextIntList().map { it - 1 }
//         when (i in stat[j][0]) {
//             true -> {
//                 stat[j][0].remove(i)
//                 stat[j][1].add(i)
//             }
//
//             false -> {
//                 stat[j][0].add(i)
//                 stat[j][1].remove(i)
//             }
//         }
//         var tmp = K
//         for (k in min(com - 1, j) until K) {
//             var (o: Set<Int>, n: Set<Int>) = stat[k]
//             val (ok, ng) = arr[k]
//             o = o - ok - ng
//             n = n - ok - ng
//             arr[k + 1] = if (o.size + ok.size <= M) {
//                 R(ok + o, ng)
//             } else {
//                 R(ok, ng + n)
//             }
//             if (i in arr[k + 1].ok || i in arr[k + 1].ng) {
//                 tmp = k + 1
//                 break
//             }
//         }
//         com = tmp
//         println(if (i in arr[com].ok) "Yes" else "No")
//     }
// }
