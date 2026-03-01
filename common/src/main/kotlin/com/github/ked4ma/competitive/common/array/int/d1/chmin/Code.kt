package com.github.ked4ma.competitive.common.array.int.d1.chmin

inline fun IntArray.chmin(i: Int, v: Int) {
    if (this[i] > v) this[i] = v
}
