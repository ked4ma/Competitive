package com.github.ked4ma.competitive.common.array.long.d1.chmin

inline fun LongArray.chmin(i: Int, v: Long) {
    if (this[i] > v) this[i] = v
}
