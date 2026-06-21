package com.github.ked4ma.competitive.common.models.tree.cartesian

import com.github.ked4ma.competitive.common.array.int.d1.*
import java.util.*

// https://youtu.be/XVu8-ZnuOiA?t=9291
// https://github.com/atcoder/live_library/blob/master/cart.cpp
// [NOTE] by default, this tree is created with descending order.
class CartesianTree<T : Comparable<T>>(a: List<T>, max: Boolean = true) {
    val n = a.size
    val rootIndex: Int
    val l = sizedIntArray(n, -1)
    val r = sizedIntArray(n, -1)

    init {
        val stack = Stack<Int>()
        for (i in 0 until n) {
            var p = -1
            while (stack.isNotEmpty() && !((a[stack.peek()] < a[i]) xor max)) {
                val j = stack.pop()
                r[j] = p
                p = j
            }
            l[i] = p
            stack.push(i)
        }
        for (i in 0 until stack.size - 1) {
            r[stack[i]] = stack[i + 1]
        }
        rootIndex = stack[0]
    }
}
