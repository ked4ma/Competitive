package com.github.ked4ma.competitive.atcoder.abc448

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.set.multi.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val A = nextIntList()
    val set = MultiSet<Int>()
    set.addAll(A.sorted().take(6))
    val rem = mutableListOf<Int>()
    repeat(Q) {
        rem.clear()
        val K = nextInt()
        val B = nextIntList().map { A[it - 1] }.sorted()
        for (b in B) {
            if (set.count(b) > 0) {
                rem.add(b)
                set.remove(b)
            }
        }
        println(set.first())
        set.addAll(rem)
    }
}
