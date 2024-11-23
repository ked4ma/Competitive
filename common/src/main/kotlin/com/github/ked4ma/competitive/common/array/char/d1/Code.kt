package com.github.ked4ma.competitive.common.array.char.d1

fun sizedCharArray(row: Int, default: Char): CharArray {
    return CharArray(row) { default }
}

fun sizedCharArray(row: Int, default: (Int) -> Char): CharArray {
    return CharArray(row) { i -> default.invoke(i) }
}