package com.github.ked4ma.competitive.atcoder.abc411

import com.github.ked4ma.competitive.common.array.boolean.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.range.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val A = nextIntList().map { it - 1 }

    val arr = sizedBooleanArray(N)
    var ans = 0
    for (i in range(Q)) {
        val a = A[i]
        var l = false
        var r = false
        if (a > 0) {
            l = arr[a - 1]
        }
        if (a < N - 1) {
            r = arr[a + 1]
        }
        if (arr[a]) { // black
            if (l && r) {
                ans++
            } else if (!l && !r) {
                ans--
            }
        } else { // white
            if (l && r) {
                ans--
            } else if (!l && !r) {
                ans++
            }
        }
        arr[a] = !arr[a]
        println(ans)
    }
}
