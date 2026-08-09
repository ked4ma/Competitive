package com.github.ked4ma.competitive.atcoder.arc226

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.mod.*
import com.github.ked4ma.competitive.common.models.number.mod.long.*
import com.github.ked4ma.competitive.common.repeat.*
import java.util.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    MOD = MOD998244353
    val N = nextInt()
    val ST = times(N) {
        val (S, T) = nextIntList()
        S to T
    }.sortedBy { it.first }

    val q = PriorityQueue<Int>()
    var ok = true
    var ans = 1.toModLong()
    for (i in 0 until N) {
        val (s, t) = ST[i]
        while (q.isNotEmpty() && q.peek() < s) q.poll()
        if (i > 0 && q.isEmpty()) {
            ans *= if (ok) 2 else 0
            ok = true
        }
        q.add(t)
        if (q.size > 2) ok = false
    }
    _debug_println(ok)
    ans *= if (ok) 2 else 0
    println(ans.toLong())
}
