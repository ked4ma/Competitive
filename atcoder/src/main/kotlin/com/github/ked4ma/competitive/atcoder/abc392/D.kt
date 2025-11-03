package com.github.ked4ma.competitive.atcoder.abc392

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import com.github.ked4ma.competitive.common.repeat.range.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val D = times(N) {
        val data = nextLongList()
        val dice = data.subList(1, data.size).groupingBy { it }.eachCount()
        data[0] to dice
    }
    var ans = 0.0
    for (i in range(N)) {
        for (j in i + 1 until N) {
            val (K1, dice1) = D[i]
            val (K2, dice2) = D[j]
            val keys = dice1.keys.intersect(dice2.keys)
            _debug_println(keys)
            var sum1 = 0.0
            for (key in keys) {
                sum1 += dice1.getOrDefault(key, 0).toLong() * dice2.getOrDefault(key, 0)
            }
            ans = max(ans, sum1 / (K1 * K2))
        }
    }
    println(ans)
}
