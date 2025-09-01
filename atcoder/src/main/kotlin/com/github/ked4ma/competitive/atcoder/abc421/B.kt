package com.github.ked4ma.competitive.atcoder.abc421

import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.debug._debug_println
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (X, Y) = nextLongList()
    fun rev(x: Long): Long {
        var n = x
        var res = 0L
        while (n > 0) {
            res = res * 10 + n % 10
            n /= 10
        }
        _debug_println(res)
        return res
    }

    val arr = sizedLongArray(10, -1)
    arr[0] = X
    arr[1] = Y
    fun fib(i: Int): Long {
        if (arr[i] < 0) {
            arr[i] = rev(fib(i - 1) + fib(i - 2))
        }
        return arr[i]
    }
    _debug_println(arr)
    println(fib(9))
}
