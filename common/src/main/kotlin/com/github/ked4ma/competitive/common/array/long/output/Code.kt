package com.github.ked4ma.competitive.common.array.long.output

fun LongArray.println(separator: String) {
    kotlin.io.println(this.joinToString(separator))
}
