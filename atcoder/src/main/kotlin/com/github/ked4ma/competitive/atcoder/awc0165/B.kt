package com.github.ked4ma.competitive.atcoder.awc0165

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = times(N) { nextInt() }
    var ans = 0
    var i = 0
    while (i < N) {
        var j = i
        while (j + 1 < N && A[j] <= A[j + 1]) j++
        ans = max(ans, j - i)
        i = j + 1
    }
    println(ans)
}
