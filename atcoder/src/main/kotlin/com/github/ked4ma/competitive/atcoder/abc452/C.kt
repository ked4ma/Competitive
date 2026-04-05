package com.github.ked4ma.competitive.atcoder.abc452

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val AB = times(N) {
        val (A, B) = nextIntList()
        A to B - 1
    }
    val M = nextInt()
    val S = times(M) { next() }
    val arr = sizedArray(N) { mutableSetOf<Char>() }
    for (i in 0 until N) {
        val (a, b) = AB[i]
        for (j in 0 until M) {
            val s = S[j]
            if (s.length != a) continue
            arr[i].add(s[b])
        }
    }
    _debug_println(arr)
    val ans = mutableListOf<String>()
    for (m in 0 until M) {
        val s = S[m]
        if (s.length != N) {
            ans.add("No")
            continue
        }
        ans.add(if ((0 until N).all { i -> arr[i].contains(s[i]) }) "Yes" else "No")
    }
    println(ans.joinToString("\n"))
}
