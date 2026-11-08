package com.github.ked4ma.competitive.atcoder.abc483

import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val cnt = mutableMapOf<String, Int>().withDefault { 0 }

    var ans = 0L
    fun countAndAdd(s: String, w: Long) {
        val c = cnt.getValue(s)
        ans += w * c
        cnt[s] = c + 1
    }

    fun create0(s: CharArray) {
        countAndAdd(s.concatToString(), (M - 1) * (M - 2) / 2L)
    }

    fun create1(s: CharArray) {
        for (i in 0 until M) {
            val c = s[i]
            s[i] = '*'
            countAndAdd(s.concatToString(), -(M - 2L))
            s[i] = c
        }
    }

    fun create2(s: CharArray) {
        for (i in 0 until M) {
            val ci = s[i]
            s[i] = '*'
            for (j in i + 1 until M) {
                val cj = s[j]
                s[j] = '*'
                countAndAdd(s.concatToString(), 1)
                s[j] = cj
            }
            s[i] = ci
        }
    }

    repeat(N) {
        val s = nextCharArray()
        create0(s)
        create1(s)
        create2(s)
    }
    println(ans)
}
//fun main() {
//    val (N, M) = nextIntList()
//    val cnt = mutableMapOf<String, Int>().withDefault { 0 }

//    fun create1(s: CharArray): List<String> {
//        return buildList {
//            for (i in 0 until M) {
//                val c = s[i]
//                s[i] = '*'
//                add(s.concatToString())
//                s[i] = c
//            }
//        }
//    }

//    fun create2(s: CharArray): List<String> {
//        return buildList {
//            for (i in 0 until M) {
//                val ci = s[i]
//                s[i] = '*'
//                for (j in i + 1 until M) {
//                    val cj = s[j]
//                    s[j] = '*'
//                    add(s.concatToString())
//                    s[j] = cj
//                }
//                s[i] = ci
//            }
//        }
//    }

//    val S = times(N) {
//        val s = nextCharArray()
//        val a = s.concatToString()
//        val b = create1(s)
//        val c = create2(s)
//        cnt[a] = cnt.getValue(a) + 1
//        b.forEach { cnt[it] = cnt.getValue(it) + 1 }
//        c.forEach { cnt[it] = cnt.getValue(it) + 1 }
//        Triple(a, b, c)
//    }
//    _debug_println(cnt)

//    var ans = 0L
//    for ((a, b, c) in S) {
//        val s0 = cnt.getValue(a) - 1
//        val s1 = b.sumOf { cnt.getValue(it) - 1 }
//        val s2 = c.sumOf { cnt.getValue(it) - 1 }
//        ans += s2 - (M - 2) * s1 + ((M - 1) * (M - 2) / 2) * s0
//    }
//    println(ans / 2)
//}

//fun main() {
//    val (N, M) = nextIntList()
//    val cnt = mutableMapOf<String, MutableSet<Int>>()
//    val S = times(N) {
//        val s = nextCharArray()
//        val list = buildList {
//            add(s.concatToString())
//            for (i in 0 until M) {
//                val c = s[i]
//                s[i] = '*'
//                add(s.concatToString())
//                s[i] = c
//            }
//            for (i in 0 until M) {
//                val ci = s[i]
//                s[i] = '*'
//                for (j in i + 1 until M) {
//                    val cj = s[j]
//                    s[j] = '*'
//                    add(s.concatToString())
//                    s[j] = cj
//                }
//                s[i] = ci
//            }
//        }
//        for (s in list) {
//            if (s !in cnt) cnt[s] = mutableSetOf()
//            cnt.getValue(s).add(it)
//        }
//        list
//    }
//    _debug_println(cnt)
//
//    var ans = 0L
//    for (i in 0 until N) {
//        val set = mutableSetOf<Int>()
//        for (s in S[i]) {
//            val x = cnt.getValue(s)
//            set += x
//        }
//        _debug_println(set)
//        ans += set.size - 1
//    }
//    println(ans / 2)
//}
//
