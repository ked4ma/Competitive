package com.github.ked4ma.competitive.atcoder.abc479

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.int.bit.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, W) = nextLongList().let { (N, W) -> N.toInt() to W }
    val AB = times(N) {
        val (A, B) = nextLongList()
        A to B
    }
    var ans = 0L
    for (i in 1 until (1 shl N)) {
        var s = 0L
        var v = 0L
        for (j in 0 until N) {
            if (i.bit(j)) {
                val (a, b) = AB[j]
                s += a
                v += b
            }
        }
        if (v <= W) ans = max(ans, s)
    }
    println(ans)
}
