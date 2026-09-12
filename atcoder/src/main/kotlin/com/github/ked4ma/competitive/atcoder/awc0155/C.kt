package com.github.ked4ma.competitive.atcoder.awc0155

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.set.multi.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val A = nextIntList().sorted()
    val B = nextIntList().sorted()
    val multiSet = MultiSet<Int>()
    multiSet.addAll(A)
    var a = 0
    var ans = 0
    for (b in B) {
        while (a < N && A[a] < b) a++
        if (a == N) {
            println(-1)
            return
        }
        if (multiSet.count(b) > 0) {
            ans++
            multiSet.remove(b)
        }
        a++
    }
    println(ans)
}
