package com.github.ked4ma.competitive.atcoder.abc444

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.int.output.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList().sorted()
    _debug_println(A)
    val ans = mutableListOf<Int>()
    fun judge(l: Int): Boolean {
        var i = 0
        var j = A.lastIndex
        while (j >= 0 && A[j] == l) j--
        _debug_println(l == 8) {"$i $j"}
        while (i < j && A[i] + A[j] == l) {
            i++
            j--
        }
        return (i > j)
    }
    if (judge(A.first() + A.last())) ans.add(A.first() + A.last())
    if (judge(A.last())) ans.add(A.last())
    ans.sorted().println(" ")
}
