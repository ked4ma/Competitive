package com.github.ked4ma.competitive.atcoder.abc456

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val A = times(3) {
        val arr = sizedIntArray(6)
        nextIntList().forEach { x ->
            arr[x - 1]++
        }
        arr
    }
    var ans = 0.0
    ans += (1.0 * A[0][3] * A[1][4] * A[2][5]) / (6 * 6 * 6)
    ans += (1.0 * A[0][3] * A[1][5] * A[2][4]) / (6 * 6 * 6)
    ans += (1.0 * A[0][4] * A[1][3] * A[2][5]) / (6 * 6 * 6)
    ans += (1.0 * A[0][4] * A[1][5] * A[2][3]) / (6 * 6 * 6)
    ans += (1.0 * A[0][5] * A[1][3] * A[2][4]) / (6 * 6 * 6)
    ans += (1.0 * A[0][5] * A[1][4] * A[2][3]) / (6 * 6 * 6)
    println(ans)
}
