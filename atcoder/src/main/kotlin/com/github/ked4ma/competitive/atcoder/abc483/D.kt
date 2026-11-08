package com.github.ked4ma.competitive.atcoder.abc483

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.max
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextLongList()
    val arr = sizedArray(N + 1) { 0L to 0L }
    for (i in (0 until N).reversed()) {
        val (l, r) = arr[i + 1]
        val min = minOf(0, A[i], l + A[i], r + A[i])
        val max = maxOf(0, A[i], l + A[i], r + A[i])
        arr[i] = min to max
    }
    _debug_println(arr)
    var x = 0L
    var xl = 0L
    var xr = 0L
    var ans = 0L
    for (i in 0 until N) {
        val a = A[i]
        val a2 = -a
        val z = x + a2
        val (l, r) = arr[i + 1]
        val min = min(xl, l + z)
        val max = max(xr, r + z)
        ans = max(ans, max - min + 1)
        x += a
        xl = min(xl, x)
        xr = max(xr, x)
        _debug_println("$i: $xl $xr")
    }
    ans = max(ans, xr - xl + 1)
    println(ans)
}
