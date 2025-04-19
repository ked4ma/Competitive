package com.github.ked4ma.competitive.atcoder.abc401

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.mod.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val MOD = 1000000000L
    val (N, K) = nextIntList()
    if (N < K) {
        println(1)
        return
    }
    val list = ArrayDeque<Long>()
    repeat(K) {
        list.add(1)
    }
    var ans = K.toLong()
    list.add(ans)
    if (K <= 10) _debug_println(list)
    repeat(N - K) {
        val tmp = ans
        ans = ans.minusMod(list.removeFirst(), MOD)
        ans = ans.plusMod(tmp, MOD)
        list.addLast(ans)
        if (K <= 10 && it < 10) _debug_println("$ans $list")
    }
    println(ans)
}
