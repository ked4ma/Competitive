package com.github.ked4ma.competitive.atcoder.abc483

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val cnt = sizedIntArray(N)
    val arr = sizedArray(N) { sortedMapOf<Int, Int>() }
    repeat(M) {
        val (a, b) = nextIntList().map { it - 1 }
        cnt[a]++
        arr[a][b] = arr[a].getOrDefault(b, 0) + 1
    }
    var first = -1
    var firstV = -1
    var second = -1
    var secondV = -1
    for (i in 0 until N) {
        if (cnt[i] > firstV) {
            second = first
            secondV = firstV
            first = i
            firstV = cnt[i]
        } else if (cnt[i] > secondV) {
            second = i
            secondV = cnt[i]
        }
    }

    for (i in 0 until N) {
        var (j, jv) = if (i == first) {
            second to secondV
        } else {
            first to firstV
        }
        for ((k, v) in arr[i]) {
            val w = cnt[k] + v
            if (w == jv) {
                j = min(j, k)
            } else if (w > jv) {
                j = k
                jv = w
            }
        }
        println(j + 1)
    }
}
