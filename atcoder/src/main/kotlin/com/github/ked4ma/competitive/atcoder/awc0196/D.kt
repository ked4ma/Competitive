package com.github.ked4ma.competitive.atcoder.awc0196

import com.github.ked4ma.competitive.common.debug._debug_println
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextIntList()
    val C = times(N) { nextIntList().withIndex().sortedBy { it.value } }

    var list = listOf(-1 to 0L, -1 to 0L)
    for (i in 0 until N) {
        val nList = mutableListOf<Pair<Int, Long>>()
        for (k in 0 until K) {
            val j = C[i][k].index
            val v = C[i][k].value
            val nv = (0 until 2).minOf {
                val (pi, pv) = list[it]
                if (j == pi) return@minOf LONG_INF
                pv + v
            }
            nList.add(j to nv)
        }
        nList.sortBy { it.second }
        list = nList
        _debug_println(list)
    }
    println(list.minOf { it.second })
}
