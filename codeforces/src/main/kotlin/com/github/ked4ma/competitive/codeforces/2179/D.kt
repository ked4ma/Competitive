package com.github.ked4ma.competitive.codeforces.`2179`

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.int.output.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    val n = nextInt()
    val arr = sizedArray(n + 1) { mutableSetOf<Int>() }
    for (i in 0 until (1 shl n)) {
        for (j in n downTo 0) {
            val k = (1 shl j) - 1
            if (k and i == k) {
                arr[j].add(i)
                break
            }
        }
    }
    val ans = buildList {
        for (i in n downTo 0) {
            addAll(arr[i].sorted())
        }
    }
    ans.println(" ")
}
