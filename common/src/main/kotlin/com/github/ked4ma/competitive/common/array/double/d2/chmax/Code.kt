package com.github.ked4ma.competitive.common.array.double.d2.chmax

inline fun Array<DoubleArray>.chmax(i: Int, j: Int, v: Double) {
    if (this[i][j] < v) this[i][j] = v
}
