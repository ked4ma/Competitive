package com.github.ked4ma.competitive.atcoder.abc476

import com.github.ked4ma.competitive.common.array.long.d2.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList().let { (N, M) -> N to M.toLong() }
    val A = nextLongList()
    val B = nextLongList()
    val C = sized2DLongArray(N, N)
    for (i in 0 until N) {
        for (j in 0 until N) {
            C[i][j] = (A[i] * B[j]) % M
        }
    }

    val n = N * 3
    val f = sized2DLongArray(n, n)
    run { // \
        val e = sized2DLongArray(n, n)
        for (i in 0 until N) {
            for (j in 0 until N) {
                e[i + 2][j + 2] -= C[i][j]
                e[i + 2 * N][j + 2 * N] += C[i][j]
            }
        }
        for (i in 0 until n - 1) {
            for (j in 0 until n - 1) {
                e[i + 1][j + 1] += e[i][j]
            }
        }
        for (i in 0 until n) {
            for (j in 0 until n) {
                f[i][j] += e[i][j]
            }
        }
    }
    run { // /
        val e = sized2DLongArray(n, n)
        for (i in 0 until N) {
            for (j in 0 until N) {
                e[i + 2][j + 2 * N - 1] += C[i][j]
                e[i + 2 * N][j + 1] -= C[i][j]
            }
        }
        for (i in 0 until n - 1) {
            for (j in 0 until n - 1) {
                e[i + 1][j] += e[i][j + 1]
            }
        }
        for (i in 0 until n) {
            for (j in 0 until n) {
                f[i][j] += e[i][j]
            }
        }
    }
    run {
        for (i in 0 until N) {
            for (j in 0 until N) {
                f[i + 1][j + 1] += C[i][j] * (N - 1).toLong()
                f[i + 1][i + 2 * N] -= C[i][j] * (N - 1).toLong()
                f[i + 2 * N][i + 1] -= C[i][j] * (N - 1).toLong()
                f[i + 2 * N][i + 2 * N] += C[i][j] * (N - 1).toLong()
            }
        }
    }

    for (i in 0 until n - 1) {
        for (j in 0 until n - 1) {
            f[i][j + 1] += f[i][j]
        }
    }
    for (i in 0 until n - 1) {
        for (j in 0 until n - 1) {
            f[i + 1][j] += f[i][j]
        }
    }

    var ans = 0L
    for (i in 0 until N) {
        for (j in 0 until N) {
            ans = ans xor (f[i + N][j + N] + i * N + j)
        }
    }
    println(ans)
}
