package com.github.ked4ma.competitive.atcoder.abc386

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.int.dim.compress.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val input = nextIntList().compress().groupingBy { it }.eachCount().values.sorted()
    println(if (input.size == 2 && ((input[0] == 1 && input[1] == 3) || (input[0] == 2 && input[1] == 2))) "Yes" else "No")
}
