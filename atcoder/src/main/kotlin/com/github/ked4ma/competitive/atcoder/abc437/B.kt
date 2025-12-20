package com.github.ked4ma.competitive.atcoder.abc437

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W, N) = nextIntList()
    val A = times(H) {
        nextIntList().toSet()
    }
    val cnt = sizedIntArray(H)
    repeat(N) {
        val B = nextInt()
        for (i in 0 until H) {
            if (B in A[i]) cnt[i]++
        }
    }
    println(cnt.max())
}
