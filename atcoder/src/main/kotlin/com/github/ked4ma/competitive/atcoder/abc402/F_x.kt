package com.github.ked4ma.competitive.atcoder.abc402

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.long.bound.*
import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import com.github.ked4ma.competitive.common.repeat.range.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextLongList().let { (N, M) -> N.toInt() to M }
    var A = times(N) { nextIntList() }
    fun enumPath(): Array<MutableSet<String>> {
        val res = sizedArray(N) { mutableSetOf<String>() }
        fun dfs(i: Int, j: Int, x: String) {
            val nx = "$x${A[i][j]}"
            if (i + j == N - 1) {
                res[i].add(nx)
                return
            }
            dfs(i + 1, j, nx)
            dfs(i, j + 1, nx)
        }
        dfs(0, 0, "")
        return res
    }

    var ten = 1L
    repeat(N) { ten = (ten * 10) % M }
    val ss = enumPath().map {
        val arr = sizedLongArray(it.size, 0)
        it.forEachIndexed { i, s ->
            var x = 0L
            for (j in range(N - 1)) {
                x = (x * 10 + (s[j] - '0')) % M
            }
            arr[i] = (x * ten) % M
        }
        arr.sort()
        arr
    }
    A = A.map { it.asReversed() }.asReversed()
    val ts = enumPath().reversedArray().map {
        val arr = sizedLongArray(it.size, 0)
        it.forEachIndexed { i, t ->
            var x = 0L
            for (j in range(N).reversed()) {
                x = (x * 10 + (t[j] - '0')) % M
            }
            arr[i] = x
        }
        arr.sort()
        arr
    }
    ss.forEach { _debug_println("ss: ${it.joinToString(" ")}") }
    ts.forEach { _debug_println("ts: ${it.joinToString(" ")}") }

    var ans = 0L
    fun f(s: LongArray, t: LongArray) {
        for (x in s) {
            val i = t.lowerBound(M - x)
            if (i > 0) {
                ans = max(ans, x + t[i - 1])
            }
            ans = max(ans, (x + t.last()) - M)
        }
    }
    for (i in range(N)) {
        f(ss[i], ts[i])
    }
    println(ans)
}
