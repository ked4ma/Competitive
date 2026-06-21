package com.github.ked4ma.competitive.atcoder.abc463

import com.github.ked4ma.competitive.common.array.boolean.d1.*
import com.github.ked4ma.competitive.common.boolean.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, X) = nextList().let { (N, X) -> N.toInt() to X[0] - 'A' }
    val arr = sizedBooleanArray(5)
    repeat(N) {
        next().forEachIndexed { i, c ->
            if (c == 'o') arr[i] = true
        }
    }
    println(arr[X].toYesNo())
}
