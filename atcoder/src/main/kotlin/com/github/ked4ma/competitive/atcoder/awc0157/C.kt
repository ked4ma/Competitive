package com.github.ked4ma.competitive.atcoder.awc0157

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.max

fun main() {
    val (N, M, S) = nextIntList()
    var x = S
    var ans = 0L

    fun f(A: Int) { // ->
        if (x + A <= M) {
            x += A
        } else {
            val a = A - (M - x)
            val i = a / M
            val j = a % M
            ans += max(0, i - (if (j == 0) 1 else 0)) + 1
            if (i % 2 == 0) {
                x = M - j
            } else {
                x = j
            }
        }
    }

    repeat(N) {
        var (C, A) = nextList().let { (C, A) -> (if (C == "R") 1 else -1) to A.toInt() }
        if (A == 0) {
            return@repeat
        }
        if (x == 0 && C == -1) {
            ans++
            C = 1
        } else if (x == M && C == 1) {
            ans++
            C = -1
        }
        when {
            C == 1 -> {
                f(A)
            }

            C == -1 -> {
                if (x - A >= 0) {
                    x -= A
                } else {
                    val a = A - x
                    x = 0
                    ans++
                    f(a)
                }
            }
        }
        _debug_println("$x $ans")
    }
    println("$x $ans")
}
