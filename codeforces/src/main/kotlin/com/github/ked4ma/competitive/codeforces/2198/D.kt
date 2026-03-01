package com.github.ked4ma.competitive.codeforces.`2198`

import com.github.ked4ma.competitive.common.array.boolean.d1.*
import com.github.ked4ma.competitive.common.input.default.*

fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    val n = next().reversed()
    var rem = 0
    run {
        var base = 1
        for (c in n) {
            rem += (c - '0') * base
            rem %= 9
            base *= 10
            base %= 9
        }
    }
    if (rem == 0) {
        println("YES")
        return
    }
    var arr = sizedBooleanArray(10)
    arr[rem] = true
    var base = 1
    for (c in n) {
        val i = c - '0'
        if (i * i >= 10) continue
        val j = (i * i - i) * base
        var pre = arr.copyOf()
        arr = pre.also { pre = arr }
        for (a in 1 until 10) {
            if (!pre[a]) continue
            arr[(a + j) % 9] = true
        }
        if (arr[0]) {
            println("YES")
            return
        }
        base *= 10
        base %= 9
    }
    println("NO")
}
