package com.github.ked4ma.competitive.atcoder.abc427

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import com.github.ked4ma.competitive.common.number.int.bit.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val edges = mutableSetOf<Pair<Int, Int>>()
    repeat(M) {
        val (u, v) = nextIntList().map { it - 1 }
        edges.add(u to v)
    }
    var ans = INT_INF
    for (i in 0 until (1 shl N)) {
        var cnt = 0
        for (u in 0 until N) {
            for (v in u + 1 until N) {
                if (i.bit(u) == i.bit(v) && u to v in edges) {
                    cnt++
                }
            }
        }
        _debug_println(N == 5) { "${i.toString(2)} $cnt" }
        ans = min(ans, cnt)
    }
    println(ans)
}
