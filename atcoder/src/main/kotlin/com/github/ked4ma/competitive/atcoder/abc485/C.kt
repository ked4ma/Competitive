package com.github.ked4ma.competitive.atcoder.abc485

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.array.int.output.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val C = nextIntList().map { it - 1 }
    val cSet = sizedArray(N) { ArrayDeque<Int>() }
    for (i in 0 until N) {
        cSet[C[i]] += i
    }

    val ans = sizedIntArray(N)
    val lMap = mutableMapOf<Int, Int>()
    val rSet = sortedSetOf<Pair<Int, Int>>(compareBy { it.second })
    for (c in 0 until N) {
        val q = cSet[c]
        if (q.isNotEmpty()) rSet += c to q.removeFirst()
    }
    for (i in 0 until N) {
        rSet -= C[i] to i
        if (cSet[C[i]].isNotEmpty()) {
            rSet += C[i] to cSet[C[i]].removeFirst()
        }
        var n = INT_INF
        for ((c, j) in lMap) {
            if (C[i] == c) continue
            n = min(n, i - j)
        }
        for ((c, j) in rSet) {
            if (C[i] == c) continue
            n = min(n, j - i)
            break
        }
        ans[i] = n

        lMap[C[i]] = i
        if (lMap.size > 2) {
            val (c, _) = lMap.minBy { it.value }
            lMap.remove(c)
        }
    }
    ans.println(" ")
}
