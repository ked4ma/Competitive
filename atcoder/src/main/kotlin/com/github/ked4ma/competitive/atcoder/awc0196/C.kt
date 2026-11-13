package com.github.ked4ma.competitive.atcoder.awc0196

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.max
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    var a1 = 0L
    var a2 = 0L
    var b1 = 0L
    var b2 = 0L
    val AB = times(N) {
        val (A, B) = nextLongList()
        if (A > a1) {
            a2 = a1
            a1 = A
        } else if (A > a2) {
            a2 = A
        }
        if (B > b1) {
            b2 = b1
            b1 = B
        } else if (B > b2) {
            b2 = B
        }
        A to B
    }
    var ans = LONG_INF
    for ((a, b) in AB) {
        var n = 0L
        if (a == a1) {
            n += max(0, (a2 + 1) - a)
        } else {
            n += max(0, (a1 + 1) - a)
        }
        if (b == b1) {
            n += max(0, (b2 + 1) - b)
        } else {
            n += max(0, (b1 + 1) - b)
        }
        ans = min(ans, n)
    }
    println(ans)
}
