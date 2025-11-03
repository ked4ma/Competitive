package com.github.ked4ma.competitive.atcoder.abc391

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.int.pow.*
import com.github.ked4ma.competitive.common.repeat.range.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val A = nextCharArray()
    var len = 3.pow(N)
    val necessary = sizedIntArray(len, 1)
    while (len > 1) {
        val nextLen = len / 3
        for (i in range(nextLen)) {
            val zeroNes = mutableListOf<Int>()
            val oneNes = mutableListOf<Int>()
            var zero = 0
            for (j in range(3)) {
                if (A[3 * i + j] == '0') {
                    zero++
                    zeroNes.add(necessary[3 * i + j])
                } else {
                    oneNes.add(necessary[3 * i + j])
                }
            }
            when (zero) {
                3 -> {
                    A[i] = '0'
                    necessary[i] = zeroNes.sorted().take(2).sum()
                }

                2 -> {
                    A[i] = '0'
                    necessary[i] = zeroNes.minOf { it }
                }

                1 -> {
                    A[i] = '1'
                    necessary[i] = oneNes.minOf { it }
                }

                0 -> {
                    A[i] = '1'
                    necessary[i] = oneNes.sorted().take(2).sum()
                }
            }
        }
        len = nextLen
    }
    _debug_println(necessary.joinToString(" "))
    println(necessary[0])
}
