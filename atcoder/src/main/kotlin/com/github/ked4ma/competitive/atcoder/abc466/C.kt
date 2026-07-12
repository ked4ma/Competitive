package com.github.ked4ma.competitive.atcoder.abc466

import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    var ans = 0
    var j = 1
    for (i in 1..N) {
        j = max(j, i)
        while (j + 1 <= N) {
            println("? $i ${j + 1}")
            val res = next()
            if (res == "Yes") {
                j++
            } else {
                break
            }
        }
        ans += (j - i)
    }
    println("! $ans")
}
