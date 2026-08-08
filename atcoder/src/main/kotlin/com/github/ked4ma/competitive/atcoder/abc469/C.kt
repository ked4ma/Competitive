package com.github.ked4ma.competitive.atcoder.abc469

import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val S = nextCharArray()
    var oCnt = 0
    var j = 1
    var xCnt = 0
    for (i in 0 until N) {
        if (S[i] == 'o') {
            oCnt++
        } else {
            xCnt = max(0, xCnt - 1)
        }
        j = max(j, i + 1)
        while (j < N && xCnt < oCnt) {
            if (S[j] == 'x') {
                xCnt++
            }
            j++
        }
        println(j)
    }
}
