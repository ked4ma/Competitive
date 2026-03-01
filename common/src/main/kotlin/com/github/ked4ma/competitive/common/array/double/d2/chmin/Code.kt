package com.github.ked4ma.competitive.common.array.double.d2.chmin

inline fun Array<DoubleArray>.chmin(i: Int, j: Int, v: Double) {
    if (this[i][j] > v) this[i][j] = v
}
