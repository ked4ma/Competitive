package com.github.ked4ma.competitive.common.models.number.mod.long

import com.github.ked4ma.competitive.common.math.mod.*
import com.github.ked4ma.competitive.common.math.modinv.*

data class ModLong(private var value: Long, val mod: Long = MOD) : Number(), Comparable<ModLong> {
    init {
        value = ((value % mod) + mod) % mod
    }

    override fun toByte(): Byte = value.toByte()
    override fun toChar(): Char = value.toInt().toChar()
    override fun toDouble(): Double = value.toDouble()
    override fun toFloat(): Float = value.toFloat()
    override fun toInt(): Int = value.toInt()
    override fun toLong(): Long = value
    override fun toShort(): Short = value.toShort()
    override fun compareTo(other: ModLong): Int = value.compareTo(other.value)

    operator fun plus(n: ModLong): ModLong = (value + n.value).toModLong(mod)
    operator fun minus(n: ModLong): ModLong = (value - n.value).toModLong(mod)
    operator fun times(n: ModLong): ModLong = (value * n.value).toModLong(mod)
    operator fun div(n: ModLong): ModLong = (value * modinv(n.value, mod)).toModLong(mod)

    operator fun plus(n: Long): ModLong = plus(n.toModLong(mod))
    operator fun minus(n: Long): ModLong = minus(n.toModLong(mod))
    operator fun times(n: Long): ModLong = times(n.toModLong(mod))
    operator fun div(n: Long): ModLong = div(n.toModLong(mod))

    operator fun plus(n: Int): ModLong = plus(n.toModLong(mod))
    operator fun minus(n: Int): ModLong = minus(n.toModLong(mod))
    operator fun times(n: Int): ModLong = times(n.toModLong(mod))
    operator fun div(n: Int): ModLong = div(n.toModLong(mod))
}

fun Int.toModLong() = this.toLong().toModLong()
fun Int.toModLong(mod: Long) = this.toLong().toModLong(mod)
fun Long.toModLong() = ModLong(this)
fun Long.toModLong(mod: Long) = ModLong(this, mod)
