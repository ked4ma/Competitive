package com.github.ked4ma.competitive.atcoder.abc472

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.vec.long.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val xy = times(N) {
        val (x, y) = nextLongList()
        LongVec(x, y)
    }

    val n2 = N * 2
    val area = sizedLongArray(n2)
    val cent = sizedArray(n2, LongVec(0, 0))
    for (i in 0 until n2 - 1) {
        val p = xy[i % N]
        val q = xy[(i + 1) % N]
        val a = p.cross(q)
        val c = (p + q) * a
        area[i + 1] = area[i] + a
        cent[i + 1] = cent[i] + c
    }

    repeat(Q) {
        var (l, r) = nextIntList().map { it - 1 }
        if (r < l) r += N
        var a = area[r] - area[l]
        var c = cent[r] - cent[l]
        run {
            val p = xy[r % N]
            val q = xy[l % N]
            val na = p.cross(q)
            val nc = (p + q) * na
            a += na
            c += nc
        }
        var (x, y) = c.let { (x, y) -> x.toDouble() to y.toDouble() }
        x /= a * 3
        y /= a * 3
        println("$x $y")
    }
}

// fun main() {
//     val (N, Q) = nextIntList()
//     val xy = times(N) {
//         val (x, y) = nextDoubleList()
//         x to y
//     }
//     val uv = times(Q) {
//         val (u, v) = nextIntList().map { it - 1 }
//         u to v
//     }.withIndex().groupBy { min(it.value.first, it.value.second) }
//     val ans = sized2DDoubleArray(Q, 2)
//     val arr = sized2DDoubleArray(N, 3)
//     for ((u, list) in uv) {
//         var i1 = (u + 1) % N
//         var i2 = (u + 2) % N
//         val end = (u - 1 + N) % N
//         arr[i1].fill(0.0)
//         while (i2 != u) {
//             val v1x = (xy[i1].first - xy[u].first)
//             val v1y = (xy[i1].second - xy[u].second)
//             val v2x = (xy[i2].first - xy[u].first)
//             val v2y = (xy[i2].second - xy[u].second)
//             val v = (v1x * v2y - v1y * v2x) / 2
//             arr[i2][0] = arr[i1][0] + ((xy[u].first + xy[i1].first + xy[i2].first) / 3) * v
//             arr[i2][1] = arr[i1][1] + ((xy[u].second + xy[i1].second + xy[i2].second) / 3) * v
//             arr[i2][2] = arr[i1][2] + v
//             i1 = i2
//             i2 = (i2 + 1) % N
//         }
//         for ((i, x) in list) {
//             if (u == x.first) {
//                 val v = x.second
//                 ans[i][0] = arr[v][0] / arr[v][2]
//                 ans[i][1] = arr[v][1] / arr[v][2]
//             } else {
//                 val v = x.first
//                 _debug_println("$x $end ${arr.map { it[2] }}")
//                 ans[i][0] =
//                     (arr[end][0] - (arr[v][0])) / (arr[end][2] - (arr[v][2]))
//                 ans[i][1] =
//                     (arr[end][1] - (arr[v][1])) / (arr[end][2] - (arr[v][2]))
//             }
//         }
//     }
//     for (a in ans) {
//         a.println(" ")
//     }
// }
//
