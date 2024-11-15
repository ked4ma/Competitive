package com.github.ked4ma.competitive.common.array.long.d1

fun sizedLongArray(row: Int, default: Long): LongArray {
    return LongArray(row) { default }
}

fun sizedLongArray(row: Int, default: (Int) -> Long): LongArray {
    return LongArray(row) { i -> default.invoke(i) }
}
