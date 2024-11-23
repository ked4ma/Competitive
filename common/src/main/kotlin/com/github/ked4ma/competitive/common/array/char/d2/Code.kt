package com.github.ked4ma.competitive.common.array.char.d2

fun sized2DCharArray(row: Int, col: Int, default: Char): Array<CharArray> {
    return Array(row) { CharArray(col) { default } }
}

fun sized2DCharArray(row: Int, col: Int, default: () -> Char): Array<CharArray> {
    return Array(row) { CharArray(col) { default.invoke() } }
}
