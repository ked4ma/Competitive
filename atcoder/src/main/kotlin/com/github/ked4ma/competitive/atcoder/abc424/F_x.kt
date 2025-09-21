package com.github.ked4ma.competitive.atcoder.abc424

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import kotlin.random.Random
import kotlin.random.nextULong

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val rnd = Random(0)
    val d = FenwickTree(N + 1)
    repeat(Q) {
        val (l, r) = nextIntList()
        if (d.sum(0, l) == d.sum(0, r)) {
            println("Yes")
            val x = rnd.nextULong()
            d.add(l, x)
            d.sub(r, x)
        } else {
            println("No")
        }
    }
}

@OptIn(ExperimentalUnsignedTypes::class)
private class FenwickTree(private val size: Int) {
    private val arr = ULongArray(size) { 0UL }

    fun add(index: Int, value: ULong) {
        _debug_require(index in 0 until size) { "index must be in range [0,$size)" }
        var i = index + 1
        while (i <= size) {
            arr[i - 1] += value
            i += i and -i
        }
    }

    fun sub(index: Int, value: ULong) {
        _debug_require(index in 0 until size) { "index must be in range [0,$size)" }
        var i = index + 1
        while (i <= size) {
            arr[i - 1] -= value
            i += i and -i
        }
    }

    // sum of [0, r)
    // @param right (exclusive)
    private fun sum(right: Int): ULong {
        var ans = 0UL
        var r = right
        while (r > 0) {
            ans += arr[r - 1]
            r -= r and -r
        }
        return ans
    }

    fun sum(left: Int, right: Int = size): ULong {
        _debug_require(left in 0..right && right <= size) { "need: 0 <= left <= right <= $size (actual: $left, $right)" }
        return sum(right) - sum(left)
    }
}
