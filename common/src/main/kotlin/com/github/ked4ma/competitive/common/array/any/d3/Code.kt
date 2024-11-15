package com.github.ked4ma.competitive.common.array.any.d3

inline fun <reified T> sized3DArray(row: Int, col: Int, dep: Int, default: T): Array<Array<Array<T>>> {
    return Array(row) { Array(col) { Array(dep) { default } } }
}

inline fun <reified T> sized3DArray(row: Int, col: Int, dep: Int, default: () -> T): Array<Array<Array<T>>> {
    return Array(row) { Array(col) { Array(dep) { default.invoke() } } }
}
