package com.github.ked4ma.competitive.common.array.int.d2

fun sized2DIntArray(row: Int, col: Int, default: Int): Array<IntArray> {
    return Array(row) { IntArray(col) { default } }
}

fun sized2DIntArray(row: Int, col: Int, default: () -> Int): Array<IntArray> {
    return Array(row) { IntArray(col) { default.invoke() } }
}
