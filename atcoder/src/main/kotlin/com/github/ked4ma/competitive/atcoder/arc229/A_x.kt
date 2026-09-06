package com.github.ked4ma.competitive.atcoder.arc229

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.debug._debug_println
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val X = nextInt()
    if (X == 0) {
        println("ATCODER")
        return
    }
    val arr = sizedIntArray(50, 0)
    for (i in 0 until 25) {
        arr[i] = 1
    }
    var n = 0
    var i = 24
    while (true) {
        for (d in 0 until 25) {
            arr[i + d] = arr[i + d + 1].also { arr[i + d + 1] = arr[i + d] }
            _debug_println(arr.joinToString(""))
            n++
            if (n == X) {
                println(arr.map { if (it == 0) 'A' else 'C' }.joinToString("R"))
                return
            }
        }
        i--
    }
}
