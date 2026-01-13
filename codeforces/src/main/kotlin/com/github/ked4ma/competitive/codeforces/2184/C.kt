package com.github.ked4ma.competitive.codeforces.`2184`

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    val (n, k) = nextIntList()
    var set = sortedSetOf(n)
    var ans = 0
    do {
        if (k in set) {
            println(ans)
            return
        }
        val next = sortedSetOf<Int>()
        for (i in set) {
            next.add(i / 2)
            next.add(i - i / 2)
        }
        set = next
        ans++
    } while (k <= set.last())
    println(-1)
}
