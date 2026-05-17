package com.github.ked4ma.competitive.atcoder.abc458

import com.github.ked4ma.competitive.common.array.long.d2.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.matrix.long.mod.*
import com.github.ked4ma.competitive.common.math.mod.*
import com.github.ked4ma.competitive.common.models.aho.corasick.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    MOD = MOD998244353
    val (N, K) = nextIntList()
    val S = times(K) { next() }

    val aho = AhoCorasick().apply {
        for (s in S) add(s)
        build()
    }

    val n = aho.size
    _debug_println(n)
    var arr = sized2DLongArray(n, n)
    for (i in 0 until n) {
        for (c in 'a'..'z') {
            val j = aho.next(i, c)
            _debug_println(N == 3) { "$i, $c -> $j" }
            if (aho.cnt(j) == 0) arr[i][j]++
        }
    }

    arr = arr.powMod(N.toLong())
    _debug_println(N == 3) { arr }
    var ans = sized2DLongArray(1, n)
    ans[0][0] = 1
    ans = ans.timesMod(arr)
    println(ans[0].fold(0L) { acc, n -> (acc + n) % MOD })
}
// fun main() {
//     MOD = MOD998244353
//     val (N, K) = nextIntList()
//     val S = times(K) { nextCharArray() }
//
//     data class Node(val i: Int, val child: MutableMap<Char, Node> = mutableMapOf(), var leaf: Boolean = false)
//
//     var nodeCnt = 0
//     val root = Node(nodeCnt++)
//     val nodes = mutableListOf(root)
//
//     fun build(s: CharArray) {
//         var cur = root
//         for (i in s.indices) {
//             val c = s[i]
//             if (c !in cur.child) {
//                 val node = Node(nodeCnt++)
//                 cur.child[c] = node
//                 nodes.add(node)
//             }
//             cur = cur.child.getValue(c)
//         }
//         cur.leaf = true
//     }
//     for (s in S) build(s)
//
//     var arr = sized2DLongArray(nodeCnt, nodeCnt)
//     run {
//         for (node in nodes) {
//             if (node.leaf) continue
//             val i = node.i
//             var rem = 26L
//             for (c in 'a'..'z') {
//                 var canRoot = true
//                 var used = false
//                 if (c in node.child) {
//                     used = true
//                     val ch = node.child.getValue(c)
//                     if (!ch.leaf) {
//                         val j = ch.i
//                         arr[i][j] = 1
//                     } else {
//                         canRoot = false
//                     }
//                 }
//                 if (canRoot && c in root.child) {
//                     used = true
//                     val ch = root.child.getValue(c)
//                     if (!ch.leaf) {
//                         val j = ch.i
//                         arr[i][j] = 1
//                     }
//                 }
//                 if (used) rem--
//             }
//             arr[i][0] = rem
//         }
//     }
//     _debug_println(arr)
//
//     arr = arr.powMod(N.toLong(), MOD)
//     var ans = sized2DLongArray(1, nodeCnt)
//     ans[0][0] = 1
//     ans = ans.timesMod(arr, MOD)
//     _debug_println(ans)
//
//     println(ans[0].fold(0L) { acc, n -> (acc + n) % MOD })
// }
