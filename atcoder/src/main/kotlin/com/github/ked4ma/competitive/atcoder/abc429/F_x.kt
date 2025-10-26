package com.github.ked4ma.competitive.atcoder.abc429

import com.github.ked4ma.competitive.common.array.char.d2.*
import com.github.ked4ma.competitive.common.array.int.d2.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.tree.segment.general.*
import com.github.ked4ma.competitive.common.number.inf.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.abs
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val S = times(3) { nextCharArray() }.let { S ->
        val s = sized2DCharArray(N, 3, ' ')
        for (i in 0 until 3) {
            for (j in 0 until N) {
                s[j][i] = S[i][j]
            }
        }
        s
    }
    val segTree = GeneralSegmentTree.getInstance<Array<IntArray>>(
        n = N,
        fx = { x1, x2 ->
            val next = sized2DIntArray(3, 3, INT_INF)
            for (k in 0 until 3) {
                for (i in 0 until 3) {
                    for (j in 0 until 3) {
                        next[i][j] = min(next[i][j], x1[i][k] + x2[k][j])
                    }
                }
            }
            next
        },
        fm = { _, m2 -> m2 },
        ex = arrayOf(
            intArrayOf(0, INT_INF, INT_INF),
            intArrayOf(INT_INF, 0, INT_INF),
            intArrayOf(INT_INF, INT_INF, 0),
        ),
    )

    fun genArr(arr: CharArray): Array<IntArray> {
        val res = sized2DIntArray(3, 3, INT_INF)
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                res[i][j] = abs(i - j)
            }
        }
        for (k in 0 until 3) {
            if (arr[k] == '.') continue
            for (i in 0 until k + 1) {
                for (j in k until 3) {
                    res[i][j] = INT_INF
                    res[j][i] = INT_INF
                }
            }
        }
        return res
//    fun genArr(c1: Char, c2: Char, c3: Char): Array<IntArray> {
//        return when ("$c1$c2$c3") {
//            "..." -> arrayOf(
//                intArrayOf(1, 2, 3),
//                intArrayOf(2, 1, 2),
//                intArrayOf(3, 2, 1),
//            )

//            "#.." -> arrayOf(
//                intArrayOf(INT_INF, INT_INF, INT_INF),
//                intArrayOf(INT_INF, 1, 2),
//                intArrayOf(INT_INF, 2, 1),
//            )

//            ".#." -> arrayOf(
//                intArrayOf(1, INT_INF, INT_INF),
//                intArrayOf(INT_INF, INT_INF, INT_INF),
//                intArrayOf(INT_INF, INT_INF, 1),
//            )

//            "..#" -> arrayOf(
//                intArrayOf(1, 2, INT_INF),
//                intArrayOf(2, 1, INT_INF),
//                intArrayOf(INT_INF, INT_INF, INT_INF),
//            )

//            "##." -> arrayOf(
//                intArrayOf(INT_INF, INT_INF, INT_INF),
//                intArrayOf(INT_INF, INT_INF, INT_INF),
//                intArrayOf(INT_INF, INT_INF, 1),
//            )

//            "#.#" -> arrayOf(
//                intArrayOf(INT_INF, INT_INF, INT_INF),
//                intArrayOf(INT_INF, 1, INT_INF),
//                intArrayOf(INT_INF, INT_INF, INT_INF),
//            )

//            ".##" -> arrayOf(
//                intArrayOf(1, INT_INF, INT_INF),
//                intArrayOf(INT_INF, INT_INF, INT_INF),
//                intArrayOf(INT_INF, INT_INF, INT_INF),
//            )

//            "###" -> arrayOf(
//                intArrayOf(INT_INF, INT_INF, INT_INF),
//                intArrayOf(INT_INF, INT_INF, INT_INF),
//                intArrayOf(INT_INF, INT_INF, INT_INF),
//            )

//            else -> throw RuntimeException()
//        }
    }
    run {
        val init = mutableListOf<Array<IntArray>>()
        for (k in 0 until N) {
            val arr = genArr(S[k])
            init.add(arr)
        }
        segTree.init(init)
    }
    val Q = nextInt()
    _debug_println(segTree.query(0, 5))
    repeat(Q) {
        val (r, c) = nextIntList().map { it - 1 }
        S[c][r] = if (S[c][r] == '.') '#' else '.'
        val arr = genArr(S[c])
        segTree.update(c, arr)
        var ans = segTree.query(0, N)[0][2] + N - 1
        if (ans >= INT_INF) ans = -1
        println(ans)
    }
}
