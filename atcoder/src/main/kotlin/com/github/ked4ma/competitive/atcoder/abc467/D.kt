package com.github.ked4ma.competitive.atcoder.abc467

import com.github.ked4ma.competitive.common.boolean.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.vec.long.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        println(solve().toYesNo())
    }
}

private fun solve(): Boolean {
    val list = nextLongList()
    val P = LongVec(list[0], list[1])
    val Q = LongVec(list[2], list[3])
    val R = LongVec(list[4], list[5])
    val S = LongVec(list[6], list[7])
    val a = P + Q
    val b = R + S
    val v = (P - Q).rotate90()
    val w = (R - S).rotate90()
    if (v.cross(w) != 0L) return true
    if (v.cross(a - b) == 0L) return true
    return false
}
// private data class P(val x: BigDecimal, val y: BigDecimal)
//
// private fun solve() {
//     val list = nextLongList()
//     val P = P(BigDecimal(list[0]), BigDecimal(list[1]))
//     val Q = P(BigDecimal(list[2]), BigDecimal(list[3]))
//     val R = P(BigDecimal(list[4]), BigDecimal(list[5]))
//     val S = P(BigDecimal(list[6]), BigDecimal(list[7]))
//     println(judge(P, Q, R, S).toYesNo())
// }
//
// private fun judge(p: P, q: P, r: P, s: P): Boolean {
//     if (p.x == q.x) {
//         if (r.x == s.x) {
//             if (p.y + q.y != r.y + s.y) return false
//         }
//     } else if (p.y == q.y) {
//         if (r.y == s.y) {
//             if (p.x + q.x != r.x + s.x) return false
//         }
//     } else {
//         if ((p.x - q.x) * (r.y - s.y) == (r.x - s.x) * (p.y - q.y)) {
//             if (((p.x * p.x - q.x * q.x) + (p.y * p.y - q.y * q.y)) * (r.y - s.y) !=
//                 ((r.x * r.x - s.x * s.x) + (r.y * r.y - s.y * s.y)) * (p.y - q.y)
//             ) return false
//         }
//     }
//     return true
// }
//
