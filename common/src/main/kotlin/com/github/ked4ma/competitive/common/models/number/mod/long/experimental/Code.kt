package com.github.ked4ma.competitive.common.models.number.mod.long.experimental

import com.github.ked4ma.competitive.common.math.mod.*
import com.github.ked4ma.competitive.common.math.modinv.*

// NOTE: experimental
// I don't want to export the constructor but this need to create mlong() fun in companion object.
// It requires import "Companion" path so we will be in trouble when formatting.
@JvmInline
value class Mlong(val x: Long) {
    operator fun plus(b: Mlong): Mlong {
        var v = x + b.x
        if (v >= MOD) v -= MOD
        return raw(v)
    }

    operator fun minus(b: Mlong): Mlong {
        var v = x - b.x
        if (v < 0) v += MOD
        return raw(v)
    }

    operator fun times(b: Mlong): Mlong = raw(x * b.x % MOD)
    operator fun div(b: Mlong): Mlong = this * inv()
    fun inv(): Mlong = raw(modinv(x, MOD))

    fun toLong() = x

    companion object {
        fun of(v: Long): Mlong {
            var x = v % MOD
            if (x < 0) x += MOD
            return Mlong(x)
        }

        private fun raw(v: Long): Mlong = Mlong(v)
    }
}

fun Long.mlong() = Mlong.of(this)
fun Int.mlong(): Mlong = this.toLong().mlong()
