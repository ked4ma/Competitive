package com.github.ked4ma.competitive.atcoder.abc390

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val A = nextIntList().toIntArray()
    var cnt = 0
    for (i in range(4).reversed()) {
        for (j in i until 4) {
            if (A[j] > A[j + 1]) {
                val tmp = A[j]
                A[j] = A[j + 1]
                A[j + 1] = tmp
                cnt++
            }
        }
    }
    _debug_println(cnt)
    _debug_println(A.joinToString(" "))
    println(if (cnt == 1) "Yes" else "No")
}
