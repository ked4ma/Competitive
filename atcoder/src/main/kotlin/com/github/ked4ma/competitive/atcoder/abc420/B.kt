package com.github.ked4ma.competitive.atcoder.abc420

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val S = times(N) { nextCharArray() }
    val score = sizedIntArray(N, 0)
    for (i in 0 until M) {
        val arr = sizedArray(2) { mutableListOf<Int>() }
        for (j in 0 until N) {
            arr[S[j][i] - '0'].add(j)
        }
        if (arr[0].isEmpty() || arr[1].isEmpty()) {
            for (j in 0 until N) {
                score[j]++
            }
        } else {
            for (j in if (arr[0].size < arr[1].size) arr[0] else arr[1]) {
                score[j]++
            }
        }
    }
    val max = score.max()
    val ans = mutableListOf<Int>()
    for (i in 0 until N) {
        if (score[i] == max) ans.add(i + 1)
    }
    println(ans.joinToString(" "))
}
