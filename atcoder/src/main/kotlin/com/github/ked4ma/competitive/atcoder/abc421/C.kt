package com.github.ked4ma.competitive.atcoder.abc421

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.tree.fenwick.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val S = nextCharArray()

    val AB = sizedIntArray(2 * N, 0).also {
        var a = 0
        var b = 1
        for (i in 0 until 2 * N) {
            if (S[i] == 'A') {
                it[i] = a
                a += 2
            } else {
                it[i] = b
                b += 2
            }
        }
    }
    _debug_println(AB)
    val BA = sizedIntArray(2 * N, 0).also {
        var a = 1
        var b = 0
        for (i in 0 until 2 * N) {
            if (S[i] == 'A') {
                it[i] = a
                a += 2
            } else {
                it[i] = b
                b += 2
            }
        }
    }
    _debug_println(AB.inversionCount())
    println(min(AB.inversionCount(), BA.inversionCount()))
}

private fun IntArray.inversionCount(): Long {
    var count = 0L
    val ft = FenwickTree(this.size)
    for (n in this) {
        count += ft.sum(n + 1)
        ft.add(n, 1)
    }
    return count
}
