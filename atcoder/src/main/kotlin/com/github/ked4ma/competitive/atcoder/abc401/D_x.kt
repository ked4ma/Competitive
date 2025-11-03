package com.github.ked4ma.competitive.atcoder.abc401

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.range.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, K) = nextIntList()
    val S = nextCharArray()

    for (i in range(S.size)) {
        if (S[i] == 'o') {
            if (i > 0 && S[i - 1] == '?') S[i - 1] = '.'
            if (i + 1 < N && S[i + 1] == '?') S[i + 1] = '.'
        }
    }
    if (S.count { it == 'o' } == K) {
        println(S.concatToString().replace('?', '.'))
        return
    }
    _debug_println(S.concatToString())
    val S2 = S.copyOf()
    for (i in range(N)) {
        if (S2[i] != '?') continue
        if (i == 0 || S2[i - 1] == '.') {
            S2[i] = 'o'
        } else {
            S2[i] = '.'
        }
    }
    val M = S2.count { it == 'o' }
    _debug_println(M)
    _debug_println(S2.concatToString())
    if (M > K) {
        println(S.concatToString())
        return
    }
    var i = 0
    while (i < N) {
        if (S[i] != '?') {
            i++
            continue
        }
        var j = 0
        while (i + j < N && S[i + j] == '?') {
            j++
        }
        if (j % 2 == 1) {
            for (k in range(j)) {
                S[i + k] = if (k % 2 == 0) 'o' else '.'
            }
        }
        i += j
    }
    println(S.concatToString())
}
