package com.github.ked4ma.competitive.common.models.number.mod.long

import com.github.ked4ma.competitive.common.math.mod.*

data class ModLong(private val value: Long, val mod: Long = MOD) : Number(), Comparable<ModLong> {
    override fun toByte(): Byte = value.toByte()
    override fun toChar(): Char = value.toInt().toChar()
    override fun toDouble(): Double = value.toDouble()
    override fun toFloat(): Float = value.toFloat()
    override fun toInt(): Int = value.toInt()
    override fun toLong(): Long = value
    override fun toShort(): Short = value.toShort()
    override fun compareTo(other: ModLong): Int = value.compareTo(other.value)

    operator fun plus(n: ModLong): ModLong = this.plus(n.value)
    operator fun minus(n: ModLong): ModLong = this.minus(n.value)
    operator fun times(n: ModLong): ModLong = this.times(n.value)
    operator fun div(n: ModLong): ModLong = this.div(n.value)

    operator fun plus(n: Long): ModLong = ((value + n) % mod).toModLong(mod)
    operator fun minus(n: Long): ModLong = ((value - n + mod) % mod).toModLong(mod)
    operator fun times(n: Long): ModLong = ((value * n) % mod).toModLong(mod)
    operator fun div(n: Long): ModLong = (value * modinv(n, mod) % mod).toModLong(mod)

    operator fun plus(n: Int): ModLong = plus(n.toLong())
    operator fun minus(n: Int): ModLong = minus(n.toLong())
    operator fun times(n: Int): ModLong = times(n.toLong())
    operator fun div(n: Int): ModLong = div(n.toLong())

    private fun modinv(num: Long, mod: Long): Long {
        var a = num
        var b = mod
        var u = 1L
        var v = 0L
        while (b > 0) {
            val t = a.div(b)
            a -= t * b
            a = b.also { b = a } // swap a and b
            u -= t * v
            u = v.also { v = u } // swap u and v
        }
        u %= mod
        if (u < 0) u += mod
        return u
    }
}

fun Int.toModLong() = this.toLong().toModLong()
fun Int.toModLong(mod: Long) = this.toLong().toModLong(mod)
fun Long.toModLong() = ModLong(this)
fun Long.toModLong(mod: Long) = ModLong(this, mod)
