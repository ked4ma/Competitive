package com.github.ked4ma.competitive.codeforces.`2178`

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    val r = nextCharArray()
    val n = r.size
    var ans = 0
    if (r[0] == 'u') {
        r[0] = 's'
        ans++
    }
    if (r[n - 1] == 'u') {
        r[n - 1] = 's'
        ans++
    }
    for (i in 1 until n - 1) {
        if (r[i] == 'u' && r[i + 1] == 'u')  {
            r[i + 1] = 's'
            ans++
        }
    }
    println(ans)
}
