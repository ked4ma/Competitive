package com.github.ked4ma.competitive.common.array.long.d1.chmax

inline fun LongArray.chmax(i: Int, v: Long) {
    if (this[i] < v) this[i] = v
}
