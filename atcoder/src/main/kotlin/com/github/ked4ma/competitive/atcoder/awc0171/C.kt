package com.github.ked4ma.competitive.atcoder.awc0171

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.long.bound.*
import com.github.ked4ma.competitive.common.list.long.cumlative.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextLongList().let { (N, K) -> N.toInt() to K }
    val A = nextLongList()
    val s = A.sum()

    if (s < K) {
        println(0)
        return
    } else if (s == K) {
        println(1)
        return
    }

    _debug_println(s)
    var ans = 0
    val cum = A.cumulativeSum()
    for (l in 0 until N) {
        if (cum[l] > K) break
        val r = cum.lowerBound(s - (K - cum[l]))
        if (cum[r] == s - (K - cum[l])) {
            _debug_println("$l $r")
            ans++
        }
    }
    println(ans) }
