package com.github.ked4ma.competitive.common.list.long.output

fun List<Long>.println(separator: String) {
    kotlin.io.println(this.joinToString(separator))
}
