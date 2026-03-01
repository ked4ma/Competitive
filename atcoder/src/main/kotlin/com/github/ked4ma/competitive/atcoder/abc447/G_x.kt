package com.github.ked4ma.competitive.atcoder.abc447

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import com.github.ked4ma.competitive.common.number.random.xorshift.ulong.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
//    val rnd = Random(0)
//    val rnd = XorShift()
    val rnd = XorShiftULong()
    val N = nextInt()
    val (K: List<Int>, A: List<Long>) = run {
        val k = mutableListOf<Int>()
        val a = mutableListOf<Long>()
        repeat(N) {
            val (K, A) = nextLongList()
            k.add(K.toInt() - 1)
            a.add(A)
        }
        k to a
    }

    class Top2(var a: Long = -LONG_INF, var b: Long = -LONG_INF, var ak: Int = -INT_INF) {
        fun add(v: Long, k: Int) {
            if (v <= b) return
            if (ak == k) {
                a = max(a, v)
                return
            }
            b = v
            if (b > a) {
                a = b.also { b = a }
                ak = k
            }
        }

        fun get(k: Int) = if (k == ak) b else a
    }

    val C = intArrayOf(0, 0, 1, 1, 0, 0)

    var ans = -1L
    repeat(500) {
        val color = sizedIntArray(N)
        repeat(N) { i ->
            color[i] = (rnd.next() % 2UL).toInt()
        }
        val dp = sizedArray(7) { Top2() }
        dp[0].add(0, -2)
        for (i in 0 until N) {
            for (j in (0 until 6).reversed()) {
                if (C[j] == color[K[i]]) {
                    val now = dp[j].get(if (j % 2 == 0) -1 else K[i]) + A[i]
                    dp[j + 1].add(now, K[i])
                }
            }
        }
        ans = max(ans, dp[6].get(-1))
    }
    println(ans)
}

private class XorShift {
    var a = 12345UL
    fun get(): ULong {
        var x = a
        x = x xor (x shl 13)
        x = x xor (x shr 7)
        x = x xor (x shl 17)
        a = x
        return x
    }
}
