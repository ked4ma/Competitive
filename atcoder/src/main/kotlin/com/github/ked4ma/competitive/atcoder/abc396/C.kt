package com.github.ked4ma.competitive.atcoder.abc396

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.max
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val B = nextLongList().sortedDescending()
    val W = nextLongList().sortedDescending()

    val arrW = sizedLongArray(M + 1, 0)
    for (i in range(M)) {
        arrW[i + 1] = max(arrW[i], arrW[i] + W[i])
    }
    var ans = 0L
    var sumB = 0L
    for (i in range(N)) {
        sumB += B[i]
        ans = max(ans, sumB + arrW[min(i + 1, M)])
    }
    println(ans)
}
