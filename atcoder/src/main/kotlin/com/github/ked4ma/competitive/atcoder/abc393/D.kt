package com.github.ked4ma.competitive.atcoder.abc393

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.range.*
import kotlin.math.abs

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    var S = nextCharArray()

//    var dl = sizedLongArray(N + 1, 0)
//    var dr = sizedLongArray(N + 1, 0)
//    repeat(2) {
//        var now = 0L
//        var one = 0
//        for (i in range(N)) {
//            if (S[i] == '0') {
//                now += one
//            } else {
//                one++
//            }
//            dl[i + 1] = now
//        }
//        dl = dr.also { dr = dl }
//        dl = dl.reversedArray()
//        dr = dr.reversedArray()
//        S = S.reversedArray()
//    }
//    var ans = Long.MAX_VALUE
//    for (i in range(N + 1)) {
//        ans = min(ans, dl[i] + dr[i])
//    }
//    println(ans)

    val P = mutableListOf<Int>()
    run {
        var cnt = 0
        for (i in range(N)) {
            if (S[i] == '1') {
                P.add(i - cnt)
                cnt++
            }
        }
    }
    val median = P[P.size / 2]
    var ans = 0L
    for (p in P) {
        ans += abs(p - median)
    }
    println(ans)

//    val ones = S.mapIndexed { i, c -> if (c == '1') i else null }.filterNotNull()
//    val diffMap = mutableMapOf<Int, Int>()
//    for (i in range(ones.size)) {
//        val key = ones[i] - i
//        diffMap[key] = diffMap.getOrDefault(key, 0) + 1
//    }
//    var ans = 0L
//    for (i in range(ones.size)) {
//        ans += abs(i - ones[i])
//    }
//    var tmp = ans
//    _debug_println(ans)
//    var a = 0
//    var b = ones.size
//    for (i in 1..N - ones.size) {
//        if (i - 1 in diffMap) {
//            val c = diffMap.getValue(i - 1)
//            a += c
//            b -= c
//        }
//        tmp += a
//        tmp -= b
//        ans = min(ans, tmp)
//        _debug_println(ans)
//    }
//    println(ans)
}
