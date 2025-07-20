package com.github.ked4ma.competitive.atcoder.abc415

import com.github.ked4ma.competitive.common.array.boolean.d1.*
import com.github.ked4ma.competitive.common.debug._debug_println
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.int.pow.*
import com.github.ked4ma.competitive.common.number.int.bit.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        println(if (solve()) "Yes" else "No")
    }
}

private fun solve(): Boolean {
    val N = nextInt()
    val M = 2.pow(N)
    val S = nextCharArray()
    val arr = sizedBooleanArray(M, false)
    arr[0] = true
    for (i in 1 until M) {
        if (S[i - 1] == '1') continue
        for (j in range(N)) {
            if (i.bit(j)) {
                arr[i] = arr[i] or arr[i xor (1 shl j)]
            }
        }
    }
    _debug_println(arr)
    return arr[M - 1]
}
