package com.github.ked4ma.competitive.common.number.random.xorshift.uint

class XorShiftUInt(seed: UInt = 0U) {
    private var st: UInt

    init {
        var z = seed + 0x9E3779B9U
        z = (z xor (z shr 16)) * 0x85ebca6bU
        z = (z xor (z shr 13)) * 0xc2b2ae35U
        st = z xor (z shr 16)
    }

    fun next(): UInt {
        var z = st
        z = z xor (z shl 13)
        z = z xor (z shr 17)
        z = z xor (z shl 5)
        st = z
        return z
    }
}
