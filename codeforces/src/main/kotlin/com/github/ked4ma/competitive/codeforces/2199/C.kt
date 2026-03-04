package com.github.ked4ma.competitive.codeforces.`2199`

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    var k = nextInt()
    if (k == 1) {
        println("YES")
        println(1)
        println(
            """
            *
            .
        """.trimIndent()
        )
        return
    }
    var ans = INT_INF
    var str = ""
    run {
        var t = 0
        val r = k / 5
        t += 3 * r
        val rem = k % 5
        if (rem == 0) {
            ans = min(ans, t)
            str = """
                ${".*.".repeat(r)}
                ${"...".repeat(r)}
            """.trimIndent()
        } else if (rem == 3) {
            ans = min(ans, t + 2)
            str = """
                ${".*.".repeat(r)}.*
                ${"...".repeat(r)}..
            """.trimIndent()
        }
    }
    if (k - 3 >= 0) {
        k -= 3
        var t = 2
        val r = k / 5
        t += 3 * r
        val rem = k % 5
        if (rem == 0) {
            ans = min(ans, t)
            str = """
                *.${".*.".repeat(r)}
                ..${"...".repeat(r)}
            """.trimIndent()
        } else if (rem == 3) {
            ans = min(ans, t + 2)
            str = """
                *.${".*.".repeat(r)}.*
                ..${"...".repeat(r)}..
            """.trimIndent()
        }
    }
    if (ans == INT_INF) {
        println("NO")
        return
    }
    println("YES")
    println(ans)
    println(str)
}
