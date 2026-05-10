package com.github.ked4ma.competitive.atcoder.abc457

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextLongList().let { (N, K) -> N.toInt() to K.toULong() }
    val A = nextLongList().map { it.toULong() }
    var l = A.min()
    var r = A[0] + K + 1UL
    while (l + 1UL < r) {
        val m = (l + r) / 2UL
        var k = 0UL
        for (i in 0 until N) {
            val j = i + 1
            val a = A[i]
            if (a > m) continue
            k += ((m - a) + (j - 1).toULong()) / j.toULong()
        }
        if (k <= K) {
            l = m
        } else {
            r = m
        }
    }
    println(l)
}
//fun main() {
//    val (N, K) = nextLongList().let { (N, K) -> N.toInt() to K.toBigDecimal() }
//    val A = nextLongList().map { it.toBigDecimal() }
//    var l = A.min()
//    var r = BigDecimal.valueOf(1, -30)
//    _debug_println(l)
//    _debug_println(r)
//    while (l + BigDecimal.ONE < r) {
//        val m = (l + r).divide(BigDecimal.TWO, RoundingMode.DOWN)
//        var k = 0L.toBigDecimal()
//        for (i in 0 until N) {
//            val j = i + 1
//            val a = A[i]
//            if (a > m) continue
//            k += ((m - a) + (j - 1).toBigDecimal()).divide(j.toBigDecimal(), RoundingMode.DOWN)
//        }
//        if (k <= K) {
//            l = m
//        } else {
//            r = m
//        }
//    }
//    println(l)
//}
