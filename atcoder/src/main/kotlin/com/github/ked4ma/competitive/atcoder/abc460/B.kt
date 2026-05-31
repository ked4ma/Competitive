package com.github.ked4ma.competitive.atcoder.abc460

import com.github.ked4ma.competitive.common.boolean.*
import com.github.ked4ma.competitive.common.debug._debug_println
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.component.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    val (X1, Y1, R1, X2, Y2, R2) = nextLongList()
    _debug_println((X2 - X1) * (X2 - X1) + (Y2 - Y1) * (Y2 - Y1))
    _debug_println((R1 + R2) * (R1 + R2))
    println(((X2 - X1) * (X2 - X1) + (Y2 - Y1) * (Y2 - Y1) in (R1 - R2) * (R1 - R2)..(R1 + R2) * (R1 + R2)).toYesNo())
}
