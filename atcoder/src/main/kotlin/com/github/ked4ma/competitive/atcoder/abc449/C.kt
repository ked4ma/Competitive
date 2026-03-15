package com.github.ked4ma.competitive.atcoder.abc449

import com.github.ked4ma.competitive.common.array.int.d2.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, L, R) = nextIntList()
    val S = nextCharArray()

    val cnt = sized2DIntArray(26, N + 1)
    for (i in 0 until N) {
        for (j in 0 until 26) {
            cnt[j][i + 1] += cnt[j][i]
        }
        cnt[S[i] - 'a'][i + 1]++
    }
    _debug_println(cnt)
    var ans = 0L
    for (i in 0 until N) {
        val l = min(i + L , N)
        val r = min(i + R + 1, N)
        ans += cnt[S[i] - 'a'].let { it[r] - it[l] }
        _debug_println("$ans: $l -> $r")
    }
    println(ans)
}
