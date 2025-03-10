package com.github.ked4ma.competitive.atcoder.abc396

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.int.inversion.count.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val A = nextIntList()
    val diff = sizedLongArray(M, 0)
    run {
        val arr = sizedArray(M) { mutableListOf<Long>() }
        for (i in range(N)) {
            arr[A[i]].add(i.toLong())
        }
        for (i in range(M)) {
            val list = arr[i]
            if (list.isEmpty()) continue
            diff[i] = (2L * list.sum()) - (((N - 1L) + (N - list.size)) * list.size / 2) - ((list.size - 1L) * list.size / 2)
//            diff[i] = (list.sum() - (list.size - 1) * list.size / 2) -
//                        (((N - 1) + (N - list.size)) * list.size / 2 - list.sum())
        }
    }
    _debug_println(diff.joinToString(" "))
    val ans = mutableListOf<Long>()
    var ic = A.inversionCount()
    var next = M - 1
    _debug_println(ic)
    for (i in range(M)) {
        ans.add(ic)
        ic += diff[next]
        next--
    }
    println(ans.joinToString("\n"))
}
