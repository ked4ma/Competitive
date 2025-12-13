package com.github.ked4ma.competitive.common.array.int.output

fun IntArray.println(separator: String) {
    kotlin.io.println(this.joinToString(separator))
}
