package com.github.ked4ma.competitive.atcoder.abc412

import com.github.ked4ma.competitive.common.array.boolean.d1.*
import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.range.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    var (L, R) = nextLongList()
    L++
    val W = (R - L + 1).toInt()
    val x = sizedLongArray(W) { i -> L + i }
    val cnt = sizedIntArray(W, 0)
    val M = 10_000_000
    val isp = sizedBooleanArray(M, true)
    isp[0] = false
    isp[1] = false
    for (i in 2 until M) {
        if (!isp[i]) continue
        for (j in i + i until M step i) isp[j] = false

        for (j in (L + i - 1) / i * i..R step i.toLong()) {
            val k = (j - L).toInt()
            while (x[k] % i == 0L) x[k] /= i.toLong()
            cnt[k]++
        }
    }

    var ans = 1
    for (i in range(W)) {
        if (x[i] != 1L) cnt[i]++
        if (cnt[i] == 1) ans++
    }
    println(ans)
    _debug_println(W == 8) { x }
    _debug_println(W == 8) { cnt }
}
