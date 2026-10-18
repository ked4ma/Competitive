package com.github.ked4ma.competitive.atcoder.abc480

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.array.int.output.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val S = times(N) { next() }
    val cnt = sizedIntArray(N)
    val map = S.withIndex().associate { it.value to it.index }
    repeat(M) {
        val T = next()
        if (T in map) {
            cnt[map.getValue(T)]++
        } else {
            var i = -1
            for (j in 0 until N) {
                if (T.length != S[j].length) continue
                var x = 0
                for (k in 0 until T.length) {
                    if (T[k] != S[j][k]) x++
                }
                if (x == 1) {
                    if (i == -1) {
                        i = j
                    } else {
                        return@repeat
                    }
                }
            }
            if (i >= 0) cnt[i]++
        }
    }
    cnt.println("\n")
}
