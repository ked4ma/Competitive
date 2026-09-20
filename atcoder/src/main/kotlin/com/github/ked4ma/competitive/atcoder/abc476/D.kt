package com.github.ked4ma.competitive.atcoder.abc476

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.long.bound.*
import com.github.ked4ma.competitive.common.list.long.cumlative.*
import com.github.ked4ma.competitive.common.math.div.ceil.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M, K) = nextIntList().let { (N, M, K) -> Triple(N, M, K.toLong()) }
    val (X, Y) = nextLongList()
    val A = nextLongList().sorted()
    val B = nextLongList().sorted()

    val aCum = A.cumulativeSum()
    val bCum = B.cumulativeSum()
    val bCeilCum = B.map { it.ceilDiv(K) }.cumulativeSum()
    _debug_println("A : $A")
    _debug_println("B : $B")
    _debug_println("A : $aCum")
    _debug_println("B : $bCum")
    _debug_println("Bc: ${B.map { it.ceilDiv(K) }}")
    _debug_println("B': $bCeilCum")
    var ans = 0
    for (j in 0..M) {
        if (bCeilCum[j] > Y) break
        val y = (Y - bCeilCum[j]) * K
        val r = bCeilCum[j] * K - bCum[j]
        val i = aCum.upperBound(y + r + X) - 1
        _debug_println("$j: ${bCeilCum[j]} $K ${bCum[j]}")
        _debug_println("$j : ${r + X} -> $i(${aCum[i]})")
        ans = max(ans, i + j)
    }
    println(ans)
}
