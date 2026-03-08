package com.github.ked4ma.competitive.atcoder.abc448

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.models.number.mod.long.*
import com.github.ked4ma.competitive.common.number.int.bit.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (K, M) = nextIntList()
    val cl = times(K) {
        val (c, l) = nextIntList()
        c to l
    }

    fun pow(b: Int, l: Int): ModLong {
        var ll = l
        var res = 1.toModLong()
        var x = b.toModLong()
        while (ll > 0) {
            if (ll.bit(0)) res = (res * x)
            x = (x * x)
            ll /= 2
        }
        return res
    }

    fun repunit(l: Int): ModLong {
        var ll = l
        var res = 0.toModLong()
        var x = 1.toModLong()
        var ten = 10.toModLong()
        while (ll > 0) {
            if (ll.bit(0)) res = (res * ten + x)
            x = (x * ten + x)
            ten = (ten * ten)
            ll /= 2
        }
        return res
    }

    fun f(): ModLong {
        var res = 0.toModLong()
        for ((c, l) in cl) {
            res = res * pow(10, l) + repunit(l) * c
        }
        return res
    }

    val p = 10007L
    ModLong.MOD = p * M
    val ans = f().toLong() / M
    println(ans)
//    val ans = (f(p) - f(M.toLong())) / M.toModLong(p)
//    println(ans.toLong())
//    _debug_println(f(M * p).toLong() / M)
}
//fun main() {
//    val (K, M) = nextIntList()
//    val MOD = 10007L
//    val offset = sizedLongArray(64)
//    offset[0] = 1
//    offset[1] = 10
//    for (i in 2 until 64) {
//        offset[i] = (offset[i - 1] * offset[i - 1]) % MOD
//    }
//    _debug_println(offset)
//
//    fun off(l: Long): Long {
//        var r = l
//        var n = 1L
//        var i = 0
//        while (r > 0) {
//            if (r.bit(0)) {
//                n *= offset[i]
//                n %= MOD
//            }
//            r /= 2
//            i++
//        }
//        n *= 10
//        n %= MOD
//        return n
//    }
//
//    fun value(l: Long): Long {
//        var c = 1L
//        var r = l
//        var i = 0
//        var n = 0L
//        while (r > 0) {
//            if (r.bit(0)) {
//                n = n * offset[i + 1] + c
//                n %= MOD
//            }
//            c += c * offset[i + 1]
//            c %= MOD
//
//            r /= 2
//            i++
//        }
//        return n
//    }
//
//    var n = 0L
//    repeat(K) {
//        val (c, l) = nextLongList()
//        val off = off(l)
//        val value = (c * value(l)) % MOD
//        n *= off
//        n %= MOD
//        n += value
//        n %= MOD
//    }
//    _debug_println(n)
//    println(((n + MOD) / M) % MOD)
//}
