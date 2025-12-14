package com.github.ked4ma.competitive.common.array.double.output

fun DoubleArray.println(separator: String) {
    kotlin.io.println(this.joinToString(separator))
}
