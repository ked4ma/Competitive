package com.github.ked4ma.competitive.codeforces.`2195`

import com.github.ked4ma.competitive.common.array.boolean.d1.*
import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val t = nextInt()
    repeat(t) {
        solve()
    }
}

private fun solve() {
    val n = nextInt()
    val a = nextIntList()
    val arr = sizedIntArray(n)
    val vis = sizedBooleanArray(n)
    for (i in 0 until n) {
        if (vis[i]) continue
        val list = mutableListOf<Int>()
        var j = i + 1
        while (j <= n) {
            vis[j - 1] = true
            list.add(a[j - 1])
            j *= 2
        }
        list.sort()
        j = i + 1
        while (j <= n) {
            arr[j - 1] = list.removeFirst()
            j *= 2
        }
    }
    _debug_println(arr)
    var ok = true
    for (i in 0 until n - 1) {
        if (arr[i] > arr[i + 1]) {
            ok = false
            break
        }
    }
    println(if (ok) "YES" else "NO")
}
