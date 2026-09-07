package com.github.ked4ma.competitive.atcoder.abc474_na

import com.github.ked4ma.competitive.common.array.long.d2.*
import com.github.ked4ma.competitive.common.debug._debug_println
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import kotlin.math.max
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = listOf(0L) + nextLongList()
    val arr = sized2DLongArray(N + 1, 2)
    var u = LONG_INF
    var l = -LONG_INF
    for (i in N downTo 1) {
        var a = 0L
        var b = 0L
        var j = 2 * i
        while (j <= N) {
            a += arr[j][0]
            b += arr[j][1]
            j += i
        }
        a = 1 - a
        b = -A[i] - b
        arr[i][0] = a
        arr[i][1] = b
        if (arr[i][0] > 0) {
            l = max(l, (-b + a - 1) / a)
        } else if (arr[i][0] < 0) {
            u = min(u, -b / a)
        }
    }
    if (l <= u && A[1] <= l) {
        println(l - A[1])
    } else {
        println(-1)
    }
    _debug_println("$l..$u")
}
