package com.github.ked4ma.competitive.common.math.mod

import com.github.ked4ma.competitive.common.math.modinv.*

// mod
const val MOD10e9_7 = 1_000_000_007L
const val MOD998244353 = 998_244_353L
const val MOD = MOD10e9_7
fun Long.plusMod(n: Long, mod: Long = MOD) = this.plus(n, mod)
fun Long.minusMod(n: Long, mod: Long = MOD) = this.minus(n, mod)
fun Long.timesMod(n: Long, mod: Long = MOD) = this.times(n, mod)
fun Long.divMod(n: Long, mod: Long = MOD) = this.div(n, mod)
fun Long.plus(n: Long, mod: Long) = (this + n) % mod
fun Long.minus(n: Long, mod: Long) = (this - n + mod) % mod
fun Long.times(n: Long, mod: Long) = (this * n) % mod
fun Long.div(n: Long, mod: Long) = (this * modinv(n, mod)) % mod
fun Collection<Long>.sumMod(mod: Long = MOD) = this.sum(mod)
fun Collection<Long>.sum(mod: Long) = this.fold(0L) { acc, l -> acc.plusMod(l, mod) }
