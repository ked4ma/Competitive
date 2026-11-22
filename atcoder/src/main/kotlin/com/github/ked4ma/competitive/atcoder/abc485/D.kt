package com.github.ked4ma.competitive.atcoder.abc485

import com.github.ked4ma.competitive.common.array.boolean.d1.*
import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val S = next().map { it - 'A' }
    val cArr = sizedIntArray(3)
    for (c in S) {
        cArr[c]++
    }
    var l = 0
    run {
        var lCnt = 0
        val lArr = sizedBooleanArray(3)
        while (l < N) {
            val c = S[l]
            cArr[c]--
            if (!lArr[c]) {
                lArr[c] = true
                lCnt++
            }
            l++
            if (lCnt == 3) break
        }
    }
    var r = N
    run {
        var rCnt = 0
        val rArr = sizedBooleanArray(3)
        while (r > 0) {
            r--
            val c = S[r]
            cArr[c]--
            if (!rArr[c]) {
                rCnt++
                rArr[c] = true
            }
            if (rCnt == 3) break
        }
    }
    _debug_println(cArr)

    var ans = 0L
    var cnt = 0
    val arr = sizedIntArray(3)
    var j = l
    for (i in l until r) {
        while (j < r && cnt < 3) {
            val c = S[j]
            cArr[c]--
            arr[c]++
            if (arr[c] == 1) cnt++
            j++
        }
        _debug_println(S.slice(i until r).map { 'A' + it })
        _debug_println(arr.all { it > 0 }) { "$i $j $r -> ${r - j + 1}" }
        if (arr.all { it > 0 }) ans += r - j + 1
        arr[S[i]]--
        if (arr[S[i]] == 0) cnt--
    }
    println(ans)
}
