package com.github.ked4ma.competitive.codeforces.`2088`

import com.github.ked4ma.competitive.common.array.char.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    val n = nextInt()
    var ok = false
    var i = n - 1
    while (i > 0) {
        println("? $i ${i + 1}")
        val res = nextInt()
        if (res == 1) {
            ok = true
            break
        }
        i--
    }
    if (!ok) {
        println("! IMPOSSIBLE")
        return
    }
    val ans = sizedCharArray(n, '?')
    ans[i - 1] = '0'
    ans[i] = '1'
    _debug_println(ans.concatToString())

    println("? $i $n")
    var cur = nextInt()
    repeat(cur - 1) {
        ans[i + 1 + it] = '1'
    }
    for (j in i + cur until n) {
        ans[j] = '0'
    }
    _debug_println(ans.concatToString())
    i--
    while (i >= 1) {
        println("? $i $n")
        val next = nextInt()
        ans[i - 1] = if (cur == next) '1' else '0'
        cur = next
        i--
    }
    println("! ${ans.concatToString()}")
}
