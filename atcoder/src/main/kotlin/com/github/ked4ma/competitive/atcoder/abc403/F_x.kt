package com.github.ked4ma.competitive.atcoder.abc403

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    // dp_expr
    // dp_term
    // dp_factor
    // dp_number <- optional
    val N = nextInt()

    val dp_expr = sizedArray(N + 1, "")
    val dp_term = sizedArray(N + 1, "")
    val dp_factor = sizedArray(N + 1, "")

    fun Array<String>.chmin(i: Int, t: String) {
        if (t.isEmpty()) return
        if (this[i] == "" || this[i].length > t.length) this[i] = t
    }

    run {
        var i = 1
        while (i <= N) {
            dp_factor[i] = i.toString()
            i = i * 10 + 1
        }
    }

    for (i in 1..N) {
        repeat(2) {
            // expr
            dp_expr.chmin(i, dp_term[i])
            for (j in 1 until i) {
                if (dp_expr[j].isEmpty()) continue
                if (dp_term[i - j].isEmpty()) continue
                dp_expr.chmin(i, dp_expr[j] + "+" + dp_term[i - j])
            }
            // term
            dp_term.chmin(i, dp_factor[i])
            for (j in 1..i) {
                if (i % j != 0) continue
                if (dp_term[j].isEmpty()) continue
                if (dp_factor[i / j].isEmpty()) continue
                dp_term.chmin(i, dp_term[j] + "*" + dp_factor[i / j])
            }
            // factor
            if (dp_expr[i].isNotEmpty()) {
                dp_factor.chmin(i, "(" + dp_expr[i] + ")")
            }
        }
    }
    for (i in 1..N) _debug_println("$i:\t ${dp_expr[i]}")
    println(dp_expr[N])
}
