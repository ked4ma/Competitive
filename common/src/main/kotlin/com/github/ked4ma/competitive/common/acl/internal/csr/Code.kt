package com.github.ked4ma.competitive.common.acl.internal.csr

import com.github.ked4ma.competitive.common.array.int.d1.*

// sparse matrix
// ref: https://qiita.com/AkariLuminous/items/31faea745b5dd4fb9edc
class CSR<E>(val n: Int, val start: IntArray, val elist: Array<E>)
typealias CSRClass<E> = CSR<E>

inline fun <reified E> CSR(n: Int, edges: List<Pair<Int, E>>): CSRClass<E> {
    val start = sizedIntArray(n + 1, 0)
    for (edge in edges) {
        start[edge.first + 1]++
    }
    for (i in 1..n) {
        start[i] += start[i - 1]
    }
    val counter = start.copyOf()
    val arr = arrayOfNulls<E?>(edges.size)
    for (edge in edges) {
        arr[counter[edge.first]++] = edge.second
    }
    @Suppress("UNCHECKED_CAST")
    val elist = arr as Array<E>
    return CSRClass(n, start, elist)
}