package com.github.ked4ma.competitive.common.array.int.d1.chmax

inline fun IntArray.chmax(i: Int, v: Int) {
    if (this[i] < v) this[i] = v
}
