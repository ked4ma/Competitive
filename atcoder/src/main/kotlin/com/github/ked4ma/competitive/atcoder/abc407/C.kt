package com.github.ked4ma.competitive.atcoder.abc407

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = nextCharArray()
    var ans = 1
    var i = 0
    while (i < S.size - 1) {
        val a = S[i] - '0'
        val b = S[i + 1] - '0'
        val db = 10 - b
        // _debug_println("$db ${(a + db) % 10} ${(b + db) % 10}")
        ans += (a + db) % 10
        ans++
        i++
    }
    ans += S.last() - '0'
    println(ans)
}
