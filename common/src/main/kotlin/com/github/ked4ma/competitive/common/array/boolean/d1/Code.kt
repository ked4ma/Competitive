package com.github.ked4ma.competitive.common.array.boolean.d1

fun sizedBooleanArray(row: Int, default: Boolean = false): BooleanArray {
    return BooleanArray(row) { default }
}

fun sizedBooleanArray(row: Int, default: () -> Boolean): BooleanArray {
    return BooleanArray(row) { default.invoke() }
}
