package com.github.ked4ma.competitive.atcoder.awc0160

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.max
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val S = times(N) {
        nextIntList()
    }
    var ans = -1
    var v = 0
    for (i in 0 until N) {
        var max = 0
        var min = INT_INF
        var sum = 0
        for (j in 0 until M) {
            sum += S[i][j]
            max = max(max, S[i][j])
            min = min(min, S[i][j])
        }
        sum -= max + min
        if (sum > v) {
            ans = i + 1
            v = sum
        }
    }
    println(ans)
}
