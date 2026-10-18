package com.github.ked4ma.competitive.atcoder.abc480

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.long.pow.*
import com.github.ked4ma.competitive.common.number.inf.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextLong()
    fun f(i: Long, a: Long, m: Int): Boolean {
        var x = N
        repeat(m) {
            try {
                x /= (i + a * it)
            } catch (e: Throwable) {
                System.err.println("$i, $a, $it ( ${i + a * it})")
                throw e
            }
        }
        return x > 0
    }

    val n = run {
        var l = 1L
        var r = 1_000_005L
        while (l + 1 < r) {
            val m = (l + r) / 2
            if (m.pow(3) - m <= N) {
                l = m
            } else {
                r = m
            }
        }
        l
    }
    var ans = 0L
    for (i in 1..n) {
        var m = 3
        var nn = N / i / (i + 1) / (i + 2)
        while (nn > 0) {
            var a = 0L
            var b = LONG_INF / 20
            while (a + 1 < b) {
                val c = max(1, (a + b) / 2)
                if (f(i, c, m)) {
                    a = c
                } else {
                    b = c
                }
            }
            _debug_println(N == 120L) { "$i $m $a" }
            ans += a
            nn /= (i + m)
            m++
        }
    }
    println(ans)
//    val m = run {
//        var i = N
//        var j = 1
//        while (i / j > 0) {
//            i /= j
//            j++
//        }
//        j--
//        _debug_println(j)
//        var a = 1L
//        for (k in 1..j) {
//            a *= k
//        }
//        _debug_println(a)
//        _debug_println(N)
//        j
//    }
//    val n = run {
//        var l = 2L
//        var r = 1_000_005L
//        _debug_println(r * r * r)
//        while (l + 1 < r) {
//            val m = (l + r) / 2
//            if (m.pow(3) - m <= N) {
//                l = m
//            } else {
//                r = m
//            }
//        }
//        l - 1
//    }
//    _debug_println(n)
//    for (i in 1..n) {
//
//    }
}
