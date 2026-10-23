package com.github.ked4ma.competitive.atcoder.awc0185

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.array.int.d1.chmax.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.long.mod.*
import com.github.ked4ma.competitive.common.math.mod.*
import com.github.ked4ma.competitive.common.math.prime.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val primes = primes(100_000).map { it.toInt() }
    val cnt = sizedIntArray(1_000_001)
    val A = nextIntList().sorted()
    for (i in 0 until N) {
        var a = A[i]
        var j = 0
        while (primes[j] * primes[j] <= a) {
            var k = 0
            while (a % primes[j] == 0) {
                a /= primes[j]
                k++
            }
            cnt.chmax(primes[j], k)
            j++
        }
        if (a > 1) {
            cnt.chmax(a, 1)
        }
    }
    run {
        var a = A[0]
        var j = 0
        while (primes[j] * primes[j] <= a) {
            var k = 0
            while (a % primes[j] == 0) {
                a /= primes[j]
                k++
            }
            cnt[primes[j]] -= k
            j++
        }
        if (a > 1) {
            cnt[a]--
        }
    }
    var ans = 1L
    MOD = MOD10e9_7
    for (i in 0 until 1_000_001) {
        if (cnt[i] == 0) continue
        val k = cnt[i]
        ans = ans.timesMod(i.toLong().powMod(k.toLong()))
    }
    println(ans)
}
