package com.github.ked4ma.competitive.atcoder.abc415

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextLongList().let { (N, M) -> N to M.toInt() }
    val AB = times(M) {
        val (A, B) = nextLongList()
        A to B
    }.groupBy(
        keySelector = { it.first },
        valueTransform = { it.second }
    ).mapValues {
        it.value.max()
    }.toList().sortedBy { (a, b) ->
        a - b
    }
    _debug_println(AB)
    _debug_println(AB.map { (a, b) -> a - b })
    var ans = 0L
    var n = N
    for ((a, b) in AB) {
        if (n < a) continue
        val d = a - b
        val j = (n - b) / d
        n -= j * d
        ans += j
    }
    println(ans)
}
