package com.github.ked4ma.competitive.atcoder.arc227

import com.github.ked4ma.competitive.common.array.char.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = next()
    val B = next()
    val C = next()
    var a = 0
    var b = 0
    var c = 0
    var cnt = 0L
    val ans = sizedCharArray(2 * N, '0')
    repeat(N) {
        while (A[a] == '0') a++
        while (B[b] == '0') b++
        while (C[c] == '0') c++
        val list = listOf(a, b, c).sorted()
        cnt += list[2] - list[0]
        ans[list[1]] = '1'
        _debug_println("$a $b $c")
        a++
        b++
        c++
    }
    println(cnt)
    println(ans.concatToString())
}
