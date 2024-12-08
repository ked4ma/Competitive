package com.github.ked4ma.competitive.atcoder.abc383

import com.github.ked4ma.competitive.common.array.boolean.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.sqrt


// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextLong()
    val primes = buildList {
        val n = sqrt(N.toDouble()).toInt() + 1
        val arr = sizedBooleanArray(n + 1, false)
        add(2L)
        for (i in 2..n step 2) {
            arr[i] = true
        }
        for (i in 3..n step 2) {
            if (arr[i]) continue
            add(i.toLong())
            for (j in i until n step i) {
                arr[j] = true
            }
        }
    }

    var ans = 0
    var i = 0
    while (i < primes.size && primes[i] * primes[i] <= N) {
        val i2 = primes[i] * primes[i]
        val j2 = N / i2
        var j = i + 1
        while (j < primes.size && primes[j] * primes[j] <= j2) {
            if (N == 200L) _debug_println("${primes[i]} ${primes[j]}")
            ans++
            j++
        }
        i++
    }
    val m = sqrt(sqrt(sqrt(N.toDouble()))).toInt()
    println(ans + primes.count { it <= m })
}
