package com.github.ked4ma.competitive.atcoder.abc468

import com.github.ked4ma.competitive.common.array.int.bound.*
import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val P = nextIntList()
    var ans = 0
    val P2 = buildList {
        var n = 0
        for (x in P) {
            if (x > n) {
                n = x
                ans++
            } else {
                add(x)
            }
        }
    }
    ans += lis(P2)

    println(ans)
}

private fun lis(P: List<Int>): Int {
    val n = P.size
    val arr = sizedIntArray(n, INT_INF)
    for (i in 0 until n) {
        val p = P[i]
        val j = arr.lowerBound(p)
        arr[j] = p
    }
    return arr.lowerBound(INT_INF)
}
