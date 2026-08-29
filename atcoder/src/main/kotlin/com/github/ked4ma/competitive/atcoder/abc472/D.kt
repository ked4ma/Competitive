package com.github.ked4ma.competitive.atcoder.abc472

import com.github.ked4ma.competitive.common.array.boolean.d2.*
import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W, K) = nextIntList()
    val S = times(H) { nextCharArray() }

    val q = ArrayDeque<Pair<Int, Int>>()
    val arr = sized2DBooleanArray(H, W)
    var ans = 0
    run {
        val h = sizedIntArray(H)
        val w = sizedIntArray(W)
        for (i in 0 until H) {
            for (j in 0 until W) {
                if (S[i][j] == '#') {
                    h[i]++
                    w[j]++
                }
            }
        }
        for (i in 0 until H) {
            if (h[i] > 0) continue
            for (j in 0 until W) {
                if (w[j] > 0) continue
                q.add(i to j)
                arr[i][j] = true
            }
        }
        ans = q.size
    }
    _debug_println(q)
    _debug_println(arr)

    val dirs = listOf(
        1 to 0,
        -1 to 0,
        0 to 1,
        0 to -1,
    )

    var k = 0
    while (k < K && q.isNotEmpty()) {
        val n = q.size
        repeat(n) {
            val (i, j) = q.removeFirst()
            for ((di, dj) in dirs) {
                val ni = i + di
                val nj = j + dj
                if (ni !in 0 until H || nj !in 0 until W || S[ni][nj] == '#' || arr[ni][nj]) continue
                arr[ni][nj] = true
                ans++
                q.add(ni to nj)
            }
        }
        k++
    }
    println(ans)
}
