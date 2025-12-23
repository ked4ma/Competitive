package com.github.ked4ma.competitive.common.list.int.output

fun List<Int>.println(separator: String) {
    kotlin.io.println(this.joinToString(separator))
}
