package com.github.ked4ma.competitive.atcoder.abc444

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList()
    val M = A.max()
    val arr = sizedIntArray(M + 1)
    arr[0] = N
    for (a in A) {
        arr[a] -= 1
    }
    val ans = sizedIntArray(M + 1)
    var sb = StringBuilder()
    for (i in 0 until M) {
        ans[i] += arr[i] % 10
        ans[i + 1] += ans[i] / 10
        ans[i] %= 10
        ans[i + 1] += arr[i] / 10
        arr[i + 1] += arr[i]
        _debug_println(ans)
        sb.append(ans[i])
    }
    sb.reverse()
    println((if (ans[M] == 0) "" else ans[M].toString()) + sb.toString())
    _debug_println(arr)
    _debug_println(ans)

}
