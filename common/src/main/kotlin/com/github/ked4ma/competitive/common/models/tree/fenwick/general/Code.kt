package com.github.ked4ma.competitive.common.models.tree.fenwick.general

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.debug.*

// https://qiita.com/R_olldIce/items/f2f7930e7f67963f0493
// http://hos.ac/slides/20140319_bit.pdf
// Also Called BIT (binary indexed tree)
class GeneralFenwickTree<T>(
    private val size: Int,
    private val arr: Array<T>,
    private val plus: (T, T) -> T,
    private val minus: (T, T) -> T,
    private val ex: T,
) {

    fun add(index: Int, value: T) {
        _debug_require(index in 0 until size) { "index must be in range [0,$size)" }
        var i = index + 1
        while (i <= size) {
            arr[i - 1] = plus(arr[i - 1], value)
            i += i and -i
        }
    }

    // sum of [0, r)
    // @param right (exclusive)
    private fun sum(right: Int): T {
        var ans = ex
        var r = right
        while (r > 0) {
            ans = plus(ans, arr[r - 1])
            r -= r and -r
        }
        return ans
    }

    fun sum(left: Int, right: Int = size): T {
        _debug_require(left in 0..right && right <= size) { "need: 0 <= left <= right <= $size (actual: $left, $right)" }
        return minus(sum(right), sum(left))
    }

    companion object {
        inline fun <reified T> instanceOf(
            n: Int,
            noinline plus: (T, T) -> T,
            noinline minus: (T, T) -> T,
            ex: T,
        ) = GeneralFenwickTree(
            n,
            sizedArray(n) { ex },
            plus,
            minus,
            ex,
        )
    }
}
