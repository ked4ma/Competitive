package com.github.ked4ma.competitive.common.array.boolean.d2

fun sized2DBooleanArray(row: Int, col: Int, default: Boolean = false): Array<BooleanArray> {
    return Array(row) { BooleanArray(col) { default } }
}

fun sized2DBooleanArray(row: Int, col: Int, default: () -> Boolean): Array<BooleanArray> {
    return Array(row) { BooleanArray(col) { default.invoke() } }
}
