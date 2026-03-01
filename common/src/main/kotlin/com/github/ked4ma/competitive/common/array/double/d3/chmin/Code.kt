package com.github.ked4ma.competitive.common.array.double.d3.chmin

inline fun Array<Array<DoubleArray>>.chmin(i: Int, j: Int, k: Int, v: Double) {
    if (this[i][j][k] > v) this[i][j][k] = v
}
