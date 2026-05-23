package com.github.ked4ma.competitive.atcoder.abc459

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val X = nextInt()
    val list = "HelloWorld".toMutableList()
    list.removeAt(X - 1)
    println(list.joinToString(""))
}
