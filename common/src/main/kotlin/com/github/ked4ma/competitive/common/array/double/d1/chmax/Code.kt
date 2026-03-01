package com.github.ked4ma.competitive.common.array.double.d1.chmax

inline fun DoubleArray.chmax(i: Int, v: Double) {
    if (this[i] < v) this[i] = v
}
