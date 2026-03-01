package com.github.ked4ma.competitive.common.array.int.d2.chmax

inline fun Array<IntArray>.chmax(i: Int, j: Int, v: Int) {
    if (this[i][j] < v) this[i][j] = v
}
