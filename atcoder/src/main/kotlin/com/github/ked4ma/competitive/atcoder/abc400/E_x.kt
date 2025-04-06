package com.github.ked4ma.competitive.atcoder.abc400

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val M = 1000000
    val arr = sizedIntArray(M + 1, 0)
    for (i in 2..M) {
        if (arr[i] > 0) continue
        for (j in i..M step i) {
            arr[j]++
        }
    }
    val list = mutableListOf<Long>()
    for (i in 2..M) {
        if (arr[i] == 2) list.add(i.toLong() * i)
    }
    val Q = nextInt()
    repeat(Q) {
        val A = nextLong()
        var l = 0
        var r = list.size
        while (l + 1 < r) {
            val m = (l + r) / 2
            if (list[m] <= A) {
                l = m
            } else {
                r = m
            }
        }
        println(list[l])
    }
}
