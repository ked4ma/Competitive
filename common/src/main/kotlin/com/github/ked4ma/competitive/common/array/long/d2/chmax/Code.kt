package com.github.ked4ma.competitive.common.array.long.d2.chmax

inline fun Array<LongArray>.chmax(i: Int, j: Int, v: Long) {
    if (this[i][j] < v) this[i][j] = v
}
