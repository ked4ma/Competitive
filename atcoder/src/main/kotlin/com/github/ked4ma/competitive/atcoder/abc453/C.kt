package com.github.ked4ma.competitive.atcoder.abc453

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.int.bit.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val L = nextLongList()
    var ans = 0
    for (i in 0 until (1 shl N)) {
        var cnt = 0
        var x = 0.5
        for (j in 0 until N) {
            val y = if (i.bit(j)) {
                x + L[j]
            } else {
                x - L[j]
            }
            if ((x > 0 && y < 0) || (x < 0 && y > 0)) {
                cnt++
            }
            x = y
        }
        ans = max(ans, cnt)
    }
    println(ans)
}
