package com.github.ked4ma.competitive.atcoder.abc457

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextLongList().let { (N, K) -> N.toInt() to K }
    val (L, A) = run {
        val L = mutableListOf<Long>()
        val A = times(N) {
            val list = nextLongList()
            val l = list[0]
            L.add(l)
            list.slice(1..l.toInt())
        }
        L to A
    }
    val C = nextLongList()
    var k = K - 1
    for (i in 0 until N) {
        if (k < C[i] * L[i]) {
            println(A[i][(k % L[i]).toInt()])
            return
        }
        k -= C[i] * L[i]
    }
}
//fun main() {
//    val (N, K) = nextLongList().let { (N, K) -> N.toInt() to K }
//    val (L, A) = run {
//        val L = mutableListOf<Long>()
//        val A = times(N) {
//            val list = nextLongList()
//            val l = list[0]
//            L.add(l)
//            list.slice(1..l.toInt())
//        }
//        L to A
//    }
//    val C = nextLongList()
//    _debug_println(L)
//    _debug_println(A)
//    _debug_println(C)
//    var k = K
//    var i = 0
//    while (k > C[i] * L[i]) {
//        k -= C[i] * L[i]
//        i++
//    }
//    k--
//    _debug_println(k)
//    _debug_println(i)
//    k %= L[i]
//    _debug_println(k)
//    println(A[i][k.toInt()])
//}
//
