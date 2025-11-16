package com.github.ked4ma.competitive.atcoder.abc432

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val X = nextCharArray()
    val cnt = sizedIntArray(10, 0)
    for (x in X) {
        cnt[x - '0']++
    }
    val sb = StringBuilder()
    for (i in 1 until 10) {
        if (cnt[i] > 0) {
            sb.append(i)
            cnt[i]--
            break
        }
    }
    for (i in 0 until 10) {
        sb.append(i.toString().repeat(cnt[i]))
    }
    println(sb)
}
