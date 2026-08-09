package com.github.ked4ma.competitive.atcoder.abc470

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.debug._debug_println
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()

    val arr = sizedIntArray(N)
    var set = mutableSetOf<Int>()

    var ans = 0
    repeat(Q) {
        val d = nextIntList()
        when (d[0]) {
            1 -> {
                val x = d[1] - 1
                ans = ans xor arr[x]
                arr[x]++
                ans = ans xor arr[x]
                set.add(x)
            }

            2 -> {
                val nset = mutableSetOf<Int>()
                for (x in set) {
                    ans = ans xor arr[x]
                    arr[x]--
                    if (arr[x] > 0) {
                        ans = ans xor arr[x]
                        nset.add(x)
                    }
                }
                set = nset
            }
        }
        println(ans)
    }
    _debug_println(arr)
}
