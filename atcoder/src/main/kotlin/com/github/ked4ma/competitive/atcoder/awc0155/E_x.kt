package com.github.ked4ma.competitive.atcoder.awc0155

import com.github.ked4ma.competitive.common.array.long.bound.*
import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val H = nextLongList().withIndex()
    val odd = H.filter { (i, h) -> (h + i) % 2 == 1L }
    val even = H.filter { (i, h) -> (h + i) % 2 == 0L }

    fun lis(l: List<IndexedValue<Long>>): Int {
        val xy = l.map { (i, h) -> i + h to i - h }.sortedWith(compareBy({ it.first }, { it.second }))
        val arr = sizedLongArray(l.size, LONG_INF)
        for ((_, y) in xy) {
            val i = arr.upperBound(y)
            arr[i] = y
        }
        return arr.lowerBound(LONG_INF)
    }

    println(max(lis(odd), lis(even)))
}
