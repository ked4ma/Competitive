package com.github.ked4ma.competitive.common.array.char.output

fun Array<CharArray>.println() {
    println(this.joinToString("\n") { it.concatToString() })
}
