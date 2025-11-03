package com.github.ked4ma.competitive.common.number.base3

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.math.int.pow.*

data class Base3(
    val exp: Int
) {
    private val n: Int
    private val p3: IntArray

    init {
        _debug_require(exp > 0) { "exp($exp) must be positive." }
        n = 3.pow(exp)
        p3 = sizedIntArray(exp + 1, 1)
        for (i in 0 until exp) {
            p3[i + 1] = p3[i] * 3
        }
    }

    // op: base3 bit array
    fun forEach(op: (IntArray) -> Unit) {
        for (m in 0 until p3[exp]) {
            val t = sizedIntArray(exp, 0)
            for (i in 0 until exp) {
                t[i] = (m / p3[i]) % 3
            }
            op(t)
        }
    }
}
