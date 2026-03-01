package com.github.ked4ma.competitive.common.array.long.d3.chmax

inline fun Array<Array<LongArray>>.chmax(i: Int, j: Int, k: Int, v: Long) {
    if (this[i][j][k] < v) this[i][j][k] = v
}
