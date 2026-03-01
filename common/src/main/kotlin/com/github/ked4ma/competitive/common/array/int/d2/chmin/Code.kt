package com.github.ked4ma.competitive.common.array.int.d2.chmin

inline fun Array<IntArray>.chmin(i: Int, j: Int, v: Int) {
    if (this[i][j] > v) this[i][j] = v
}
