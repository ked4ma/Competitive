package com.github.ked4ma.competitive.atcoder.abc439

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.list.int.output.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val list = buildList {
        var i = 1
        while (i * i <= N) {
            add(i * i)
            i++
        }
    }
    val cnt = sizedIntArray(N + 1)
    for (i in 0 until list.size) {
        for (j in i + 1 until list.size) {
            val n = list[i] + list[j]
            if (n <= N) {
                cnt[n]++
            }
        }
    }
    val ans = mutableListOf<Int>()
    for (i in 1..N) {
        if (cnt[i] == 1) ans.add(i)
    }
    println(ans.size)
    ans.println(" ")
//    val ans = mutableListOf<Int>()
//    var k = list.lastIndex
//    for (i in 0 until list.size) {
//        val a = list[i]
//        while (k > i && list[k] > N - a) k--
//        if (i == k) break
//        for (j in i + 1..k) {
//            val n = list[i] + list[j]
//            ans.add(n)
//        }
//    }
//    ans.sort()
//    var cnt = 0
//    val sj = StringJoiner(" ")
//    for (i in 0 until ans.size) {
//        if (i > 0 && ans[i - 1] == ans[i]) continue
//        if (i < ans.size - 1 && ans[i] == ans[i + 1]) continue
//        cnt++
//        sj.add("${ans[i]}")
//    }
//    println(cnt)
//    println(sj.toString())
}
