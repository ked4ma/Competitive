package com.github.ked4ma.competitive.common.array.int.d3.chmax

inline fun Array<Array<IntArray>>.chmax(i: Int, j: Int, k: Int, v: Int) {
    if (this[i][j][k] < v) this[i][j][k] = v
}
