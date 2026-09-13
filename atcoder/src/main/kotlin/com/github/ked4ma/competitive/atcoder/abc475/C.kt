package com.github.ked4ma.competitive.atcoder.abc475

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    var (N, S, L) = nextLongList().let { (N, S, L) -> Triple(N.toInt(), S.toInt() - 1, L) }
    var A = nextLongList()
    var ans = 0
    repeat(2) { k ->
        var i = S
        var sum = 0L
        while (i + 1 < N && sum + A[i] <= L) {
            sum += A[i]
            i++
        }
        ans = max(ans, i - S + 1)
        _debug_println("$k: $i($S) $sum")
        for (j in (0 until S).reversed()) {
            sum += 2 * A[j]
            while (i > 0 && sum > L) {
                sum -= A[i - 1]
                i--
            }
            _debug_println("$k: $j $i $sum")
            if (i < S) break
            ans = max(ans, i - j + 1)
        }
        A = A.asReversed()
        S = N - 1 - S
    }
    println(ans)
}
