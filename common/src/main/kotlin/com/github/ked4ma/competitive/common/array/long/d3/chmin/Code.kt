package com.github.ked4ma.competitive.common.array.long.d3.chmin

inline fun Array<Array<LongArray>>.chmin(i: Int, j: Int, k: Int, v: Long) {
    if (this[i][j][k] > v) this[i][j][k] = v
}
