package com.github.ked4ma.competitive.atcoder.abc478

import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, V) = nextIntList()
    val W = nextIntList()
    var ans = 0
    for (i in 0 until N) {
        for (j in i + 1 until N) {
            for (k in j + 1 until N) {
                if (i + j + k + 3 <= V) {
                    ans = max(ans, W[i] + W[j] + W[k])
                }
            }
        }
    }
    println(ans)
}
