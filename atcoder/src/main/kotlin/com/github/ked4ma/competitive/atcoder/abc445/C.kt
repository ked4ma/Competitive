package com.github.ked4ma.competitive.atcoder.abc445

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.int.output.*
import com.github.ked4ma.competitive.common.number.int.bit.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextIntList().map { it - 1 }
    var a = A.toIntArray()
    repeat(100) {
        a = ten(a)
    }
    a.map { it + 1 }.println(" ")
}

private fun ten(arr: IntArray): IntArray {
    val n = arr.size
    val res = sizedIntArray(n) { it }
    var a = arr.copyOf()
    var k = 10
    while (k > 0) {
        if (k.bit(0)) {
            for (i in 0 until n) {
                res[i] = a[res[i]]
            }
        }
        var pre = sizedIntArray(n)
        a = pre.also { pre = a }
        for (i in 0 until n) {
            a[i] = pre[pre[i]]
        }
        k /= 2
    }
    return res
}
