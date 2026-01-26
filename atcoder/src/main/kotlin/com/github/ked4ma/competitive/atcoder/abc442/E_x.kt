package com.github.ked4ma.competitive.atcoder.abc442

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.vec.long.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val XY = times(N) {
        val (X, Y) = nextLongList()
        LongVec(X, Y)
    }.withIndex().sortedWith({ a, b -> cmp(a.value, b.value) })
    val idx = sizedIntArray(N)
    for (i in 0 until N) {
        idx[XY[i].index] = i
    }
    val l = sizedIntArray(N) { it }
    val r = sizedIntArray(N) { it }
    for (i in 0 until N - 1) {
        if (cmp(XY[i].value, XY[i + 1].value) == 0) l[i + 1] = l[i]
    }
    for (i in (0 until N - 1).reversed()) {
        if (cmp(XY[i].value, XY[i + 1].value) == 0) r[i] = r[i + 1]
    }
    _debug_println(l)
    _debug_println(r)
    repeat(Q) {
        var (b, a) = nextIntList().map { it - 1 }
        a = l[idx[a]]
        b = r[idx[b]]
        if (a > b) b += N
        println(b - a + 1)
    }
}

// fun main() {
//     val (N, Q) = nextIntList()
//     val XY = times(N) {
//         val (X, Y) = nextLongList()
//         LongVec(X, Y)
//     }
//     val arr = XY.sortedWith({ a, b -> cmp(a, b) })
//     _debug_println(arr)
//     repeat(Q) {
//         val (A, B) = nextIntList().map { it - 1 }
//         if (cmp(XY[A], XY[B]) >= 0) {
//             _debug_println("${arr.upperBound(XY[A])} ${arr.lowerBound(XY[B])}")
//             println(arr.upperBound(XY[A]) - arr.lowerBound(XY[B]))
//         } else {
//             println(N - (arr.lowerBound(XY[B]) - arr.upperBound(XY[A])))
//         }
//     }
// }
//
fun cmp(a: LongVec, b: LongVec): Int {
    val ah = if (a.y < 0 || (a.y == 0L && a.x < 0)) 1 else 0
    val bh = if (b.y < 0 || (b.y == 0L && b.x < 0)) 1 else 0
    if (ah != bh) return ah - bh
    val c = a.cross(b)
    if (c == 0L) return 0
    return if (c > 0) -1 else 1
}
//
// // ref: https://webbibouroku.com/Blog/Article/cs-lowerbound-upperbound
// // A = [1, 1, 2, 3, 3, 4], v = 3
// //               ↑
// // returns index "3"
// private fun List<LongVec>.lowerBound(v: LongVec): Int {
//     var l = 0
//     var r = this.lastIndex
//     while (l <= r) {
//         val m = (l + r) / 2
//         if (cmp(this[m], v) < 0) {
//             l = m + 1
//         } else {
//             r = m - 1
//         }
//     }
//     return l
// }
//
// // ref: https://webbibouroku.com/Blog/Article/cs-lowerbound-upperbound
// // A = [1, 1, 2, 3, 3, 4], v = 3
// //                     ↑
// // returns index "5"
// private fun List<LongVec>.upperBound(v: LongVec): Int {
//     var l = 0
//     var r = this.lastIndex
//     while (l <= r) {
//         val m = (l + r) / 2
//         if (cmp(this[m], v) <= 0) {
//             l = m + 1
//         } else {
//             r = m - 1
//         }
//     }
//     return l
// }
//
