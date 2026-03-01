package com.github.ked4ma.competitive.common.array.double.d1.chmin

inline fun DoubleArray.chmin(i: Int, v: Double) {
    if (this[i] > v) this[i] = v
}
