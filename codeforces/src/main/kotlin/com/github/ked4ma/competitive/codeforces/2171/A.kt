package com.github.ked4ma.competitive.codeforces.`2171`

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        val n = nextInt()
        if (n % 2 != 0) {
            println(0)
            return@repeat
        }
        var ans = 0
        for (i in 0..n step 2) {
            if ((n - i) % 4 != 0) continue
            ans++
        }
        println(ans)
    }
}
