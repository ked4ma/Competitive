package com.github.ked4ma.competitive.common.array.wrap.d1

import com.github.ked4ma.competitive.common.array.wrap.WrappedArray

inline fun <reified T> sizedWrappedArray(size: Int, default: T): WrappedArray<T> {
    return WrappedArray.of(size) { default }
}

inline fun <reified T> sizedWrappedArray(size: Int, noinline default: (Int) -> T): WrappedArray<T> {
    return WrappedArray.of(size, default)
}
