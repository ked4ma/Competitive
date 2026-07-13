package com.github.ked4ma.competitive.atcoder.arc224

import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    val K = nextLong()
    var ans = 0L
    for (i in 0 until 100) {
        ans += K
        val s = ans.toString()
        var n = ans
        var cnt = 0
        var cur = 0
        while (n != 0L) {
            if (n % 10 == 0L) {
                cur++
            } else {
                cnt = max(cnt, cur)
                cur = 0
            }
            n /= 10
        }
        if (cnt >= 2) break
    }
    println(ans)
}
