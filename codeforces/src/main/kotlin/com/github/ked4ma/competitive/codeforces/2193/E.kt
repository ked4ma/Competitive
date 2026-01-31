package com.github.ked4ma.competitive.codeforces.`2193`

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import java.util.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    val n = nextInt()
    val a = nextIntList()
    val b = a.toSet()
    val c = sizedIntArray(n + 1, INT_INF)
    if (1 in b) c[1] = 1
    val nums = mutableListOf<Int>()
    for (i in 2..n) {
        if (i in b) {
            c[i] = 1
            nums.add(i)
        } else if (c[i] < INT_INF) {
            nums.add(i)
        }
        if (c[i] < INT_INF) {
            for (j in nums) {
                if (i.toLong() * j > n) break
                c[i * j] = min(c[i * j], c[i] + c[j])
            }
        }
    }
    val sb = StringJoiner(" ")
    for (i in 1..n) {
        var m = c[i]
        if (m == INT_INF) m = -1
        sb.add(m.toString())
    }
    println(sb)
}
