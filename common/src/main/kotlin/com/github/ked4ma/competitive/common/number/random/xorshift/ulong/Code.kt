package com.github.ked4ma.competitive.common.number.random.xorshift.ulong

class XorShiftULong(seed: ULong = 0U) {
    private var st: ULong

    init {
        // scramble seed
        var z = seed + 0x9E3779B97F4A7C15UL
        z = (z xor (z shr 30)) * 0xBF58476D1CE4E5B9UL
        z = (z xor (z shr 27)) * 0x94D049BB133111EBUL
        st = z xor (z shr 31)
    }

    fun next(): ULong {
        var z = st
        z = z xor (z shl 13)
        z = z xor (z shr 7)
        z = z xor (z shl 17)
        st = z
        return z
    }
}
