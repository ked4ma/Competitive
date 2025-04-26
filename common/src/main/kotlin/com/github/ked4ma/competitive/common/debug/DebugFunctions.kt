package com.github.ked4ma.competitive.common.debug

// Debug Functions
// set "_debug_" prefix for delete this output for submit.

// # Output
@Suppress("FunctionName")
fun _debug_print(data: Any) = print("[DEBUG] $data")

@Suppress("FunctionName")
fun _debug_println(data: Any) {
    when (data) {
        is Array<*> -> {
            if (data.isNotEmpty() && isIterable(data[0]!!)) {
                data.forEach {
                    _debug_println(it!!)
                }
            } else {
                _debug_println(data.joinToString(" "))
            }
        }

        is List<*> -> {
            if (data.isNotEmpty() && isIterable(data[0]!!)) {
                data.forEach { _debug_println(it!!) }
            } else {
                _debug_println(data.joinToString(" "))
            }
        }

        is ByteArray -> _debug_println(data.joinToString(" "))
        is CharArray -> _debug_println(data.joinToString(" "))
        is ShortArray -> _debug_println(data.joinToString(" "))
        is IntArray -> _debug_println(data.joinToString(" "))
        is LongArray -> _debug_println(data.joinToString(" "))
        is FloatArray -> _debug_println(data.joinToString(" "))
        is DoubleArray -> _debug_println(data.joinToString(" "))
        is BooleanArray -> _debug_println(data.joinToString(" "))
        else -> data.toString().split("\n").forEach { println("[DEBUG] $it") }
    }
}

@Suppress("FunctionName")
fun _debug_println(show: Boolean, value: () -> Any) {
    if (!show) return
    _debug_println(value())
}

private fun isIterable(data: Any) =
    data is Array<*> || data is List<*> ||
            data is ByteArray || data is CharArray ||
            data is ShortArray || data is IntArray || data is LongArray ||
            data is FloatArray || data is DoubleArray ||
            data is BooleanArray

@Suppress("FunctionName")
fun _debug_require(value: Boolean, lazyMessage: () -> Any) = require(value, lazyMessage)
