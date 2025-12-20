package com.github.ked4ma.competitive.codeforces.`2180`

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.array.int.output.*
import com.github.ked4ma.competitive.common.debug._debug_println
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.long.bit.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    _debug_println("----")
    val (n, k) = nextIntList().let { (n, k) -> n.toLong() to k }
    if (k % 2 == 1) {
        println((0 until k).map { n }.joinToString(" "))
        return
    }
    val a = sizedIntArray(k, 0)
    var p = 0
    for (i in 30 downTo 0) {
        _debug_println("i=$i")
        if (n.bit(i)) {
            for (j in 0 until k) {
                if (j != min(p, k - 1)) {
                    a[j] += 1 shl i
                }
            }
            if (p < k) p++
        } else {
            for (j in 0 until p / 2 * 2) {
                a[j] += 1 shl i
            }
        }
        _debug_println(p)
    }
    a.println(" ")
}
