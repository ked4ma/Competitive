package com.github.ked4ma.competitive.atcoder.abc464

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val color = sizedIntArray(N)
    var ans = 0
    val ADB = times(N) {
        val (A, D, B) = nextIntList().map { it - 1 }
        if (color[A] == 0) ans++
        color[A]++
        Triple(D, A, B)
    }.sortedBy { it.first }
    _debug_println(color)

    var i = 0
    for (j in 0 until M) {
        while (i < N && ADB[i].first == j) {
            val (_, A, B) = ADB[i]
            color[A]--
            if (color[A] == 0) ans--
            if (color[B] == 0) ans++
            color[B]++
            i++
        }
        println(ans)
    }
}
