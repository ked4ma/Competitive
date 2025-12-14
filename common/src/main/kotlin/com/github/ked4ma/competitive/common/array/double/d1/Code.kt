package com.github.ked4ma.competitive.common.array.double.d1

fun sizedDoubleArray(row: Int, default: Double = 0.0): DoubleArray {
    return DoubleArray(row) { default }
}

fun sizedDoubleArray(row: Int, default: (Int) -> Double): DoubleArray {
    return DoubleArray(row) { i -> default.invoke(i) }
}
