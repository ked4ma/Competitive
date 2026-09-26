package com.github.ked4ma.competitive.atcoder.abc477

import com.github.ked4ma.competitive.common.array.boolean.d1.*
import com.github.ked4ma.competitive.common.array.char.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    data class D(val t: Int, val c: Int)

    val list = times(Q) {
        val (t, c) = nextList()
        when (t.toInt()) {
            1 -> D(t.toInt(), c.toInt() - 1)
            2 -> D(t.toInt(), c[0] - 'a')
            else -> throw IllegalArgumentException()
        }
    }
    val tiles = sizedBooleanArray(N)
    for ((t, c) in list) {
        if (t == 1) {
            val x = c
            tiles[x] = !tiles[x]
        }
    }
    var s = buildSet {
        for (i in 0 until N) {
            if (!tiles[i]) add(i)
        }
    }.toMutableSet()
    val ans = sizedCharArray(N, ' ')
    for ((t, c) in list.asReversed()) {
        when (t) {
            1 -> {
                val x = c
                tiles[x] = !tiles[x]
                if (ans[x] == ' ') {
                    if (!tiles[x]) s.add(x)
                    else s.remove(x)
                }
            }

            2 -> {
                for (i in s) {
                    ans[i] = 'a' + c
                }
                s = mutableSetOf()
//                s.clear()
            }
        }
    }
    for (i in s) {
        ans[i] = 'a'
    }
    println(ans.concatToString())
}
// fun main() {
//     val (N, Q) = nextIntList()
//     val list = times(Q) { nextList() }
//     val c = sizedCharArray(Q + 1, 'a')
//     val arr = sizedIntArray(Q + 1, -1)
//     val tiles = sizedArray(N) { mutableListOf(0) }
//     for (i in 0 until Q) {
//         val q = list[i]
//         c[i + 1] = c[i]
//         arr[i + 1] = arr[i]
//         when (q[0]) {
//             "1" -> {
//                 val x = q[1].toInt() - 1
//                 tiles[x].add(i)
//             }
//
//             "2" -> {
//                 arr[i + 1] = i
//                 c[i + 1] = q[1][0]
//             }
//         }
//     }
//     val ans = sizedCharArray(N, 'a')
//     for (i in 0 until N) {
//         val t = tiles[i] + listOf(Q - 1)
//         for ((l, r) in t.windowed(2, 2)) {
//             if (arr[l] < arr[r + 1]) {
//                 ans[i] = c[r + 1]
//             }
//         }
// //        _debug_println("$i ${t.windowed(2, 2)}")
//     }
//     _debug_println(arr)
//     println(ans.concatToString())
// }
//
