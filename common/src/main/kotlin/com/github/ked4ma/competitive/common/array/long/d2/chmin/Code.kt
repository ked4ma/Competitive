package com.github.ked4ma.competitive.common.array.long.d2.chmin

inline fun Array<LongArray>.chmin(i: Int, j: Int, v: Long) {
    if (this[i][j] > v) this[i][j] = v
}
