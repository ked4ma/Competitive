package com.github.ked4ma.competitive.common.array.double.d2

fun sized2DDoubleArray(row: Int, col: Int, default: Double): Array<DoubleArray> {
    return Array(row) { DoubleArray(col) { default } }
}

fun sized2DDoubleArray(row: Int, col: Int, default: () -> Double): Array<DoubleArray> {
    return Array(row) { DoubleArray(col) { default.invoke() } }
}
