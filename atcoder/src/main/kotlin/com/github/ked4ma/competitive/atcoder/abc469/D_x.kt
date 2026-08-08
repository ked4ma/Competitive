package com.github.ked4ma.competitive.atcoder.abc469

import com.github.ked4ma.competitive.common.debug._debug_println
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.max
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val AB = times(M) {
        val (A, B) = nextIntList()
        A to B
    }
    _debug_println(AB)
    val (a, b) = AB[0]
    val ans = mutableSetOf<Pair<Int, Int>>()
    fun calc(x: Int) {
        var ok = true
        var set: Set<Int>? = null
        for (i in 1 until M) {
            val set2 = setOf(AB[i].first, AB[i].second)
            if (x !in set2) {
                ok = false
                set = set?.intersect(set2) ?: set2
            }
        }
        if (ok) {
            for (i in 1..N) {
                if (x == i) continue
                ans.add(min(x, i) to max(x, i))
            }
        } else {
            for (i in set!!) {
                ans.add(min(x, i) to max(x, i))
            }
        }
    }
    calc(a)
    calc(b)
    println(ans.size)
    _debug_println(ans)
}
