package com.github.ked4ma.competitive.atcoder.abc385

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.range.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val H = nextIntList()

    var ans = 1
    H.withIndex().groupBy(
        keySelector = { it.value },
        valueTransform = { it.index }
    ).values.map { it.sorted() }.forEach { list ->
        val set = list.toSet()
        for (i in range(list.size)) {
            for (j in i + 1 until list.size) {
                var cnt = 1
                var c = list[i]
                val d = list[j] - list[i]
                while (c + d in set) {
                    cnt++
                    c += d
                }
                ans = max(ans, cnt)
            }
        }
    }
    println(ans)
}
