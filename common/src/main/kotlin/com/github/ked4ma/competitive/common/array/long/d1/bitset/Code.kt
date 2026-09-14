package com.github.ked4ma.competitive.common.array.long.d1.bitset

// bitset shift for kotlin
/**
 * Performs `this |= this << shift` on this [LongArray] as a bitset.
 *
 * Each [Long] stores 64 consecutive bits:
 *
 * ```
 * this[0]          this[1]          this[2]
 * ┌──────────────┐ ┌──────────────┐ ┌──────────────┐
 * │   bits 0..63 │ │ bits 64..127 │ │bits 128..191 │ ...
 * └──────────────┘ └──────────────┘ └──────────────┘
 *       64 bits          64 bits          64 bits
 * ```
 *
 * This representation enables bitset-optimized DP, such as subset-sum DP,
 * processing 64 DP states at once and reducing O(N * S) to O(N * S / 64).
 *
 * The bitset is updated in place.
 */
infix fun LongArray.orShl(shift: Int): LongArray {
    val word = shift / 64
    val bit = shift % 64
    for (i in lastIndex downTo word) {
        var x = this[i - word] shl bit
        if (bit != 0 && i - word - 1 >= 0) {
            x = x or (this[i - word - 1] ushr (64 - bit))
        }
        this[i] = this[i] or x
    }
    return this
}
