package com.github.ked4ma.competitive.atcoder.abc467

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val A = nextIntList()
    val B = nextIntList().toIntArray()

    fun f(a0: Int): Int {
        val a = A.toIntArray()
        var res = a0
        a[0] += a0
        for (i in 1 until N) {
            if ((a[i - 1] + a[i]) % M != B[i - 1]) {
                a[i]++
                res++
            }
        }
        return res
    }
    println(min(f(0), f(1)))
//    fun f(a0: Int, a1: Int): Int {
//        val a = A.toIntArray()
//        var res = a0 + a1
//        a[0] += a0
//        a[1] += a1
//        if ((a[0] + a[1]) % M != B[0]) return INT_INF
//        for (i in 1 until N - 1) {
//            if ((a[i] + a[i + 1]) % M != B[i]) {
//                a[i + 1]++
//                res++
//            }
//        }
//        return res
//    }
//
//    var ans = INT_INF
//    ans = min(ans, f(0, 0))
//    ans = min(ans, f(0, 1))
//    ans = min(ans, f(1, 0))
//    ans = min(ans, f(1, 1))
//    println(ans)
}
