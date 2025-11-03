package com.github.ked4ma.competitive.atcoder.abc393

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.range.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val S = nextCharArray()
    var ans = 0
    for (i in range(S.size - 2)) {
        if (S[i] != 'A') continue
        var j = i + 1
        var k = j + 1
        while (k < S.size) {
            _debug_println("$i $j $k")
            if (S[j] == 'B' && S[k] == 'C') ans++
            j++
            k = j + (j - i)
            _debug_println("next: $i $j $k")
        }
    }
    println(ans)
}
