package com.github.ked4ma.competitive.codeforces.`2266`

import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.max

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    val n = nextInt()
    val a = nextLongList()
    val list = buildList {
        for (i in 0 until n) {
            add(a[i] - i)
        }
    }.sorted().distinct()
    var l = 0
    var r = 1
    var ans = 1
    while (r < list.size) {
        if (list[l] + (r - l) == list[r]) {
            r++
        } else {
            ans = max(ans, r - l)
            l = r
            r = l + 1
        }
    }
//    val arr = sizedLongArray(n)
//    val q = PriorityQueue<Long>(reverseOrder())
//    for (i in 0 until n) {
//        q.add(a[i] - i)
//    }
//    _debug_println(q.toList().sortedDescending())
//    for (i in 0 until n) {
//        arr[i] = q.poll() + i
//    }
//    var l = 0
//    var r = 1
//    var ans = 1
//    while (r < n) {
//        if (arr[l] == arr[r]) {
//            r++
//        } else {
//            ans = max(ans, r - l)
//            l = r
//            r++
//        }
//    }
    ans = max(ans, r - l)
    println(ans)
//    _debug_println(arr)
//    _debug_println("m = ${a.sum() / n}")
}
