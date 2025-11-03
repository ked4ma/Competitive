package com.github.ked4ma.competitive.atcoder.abc416

import com.github.ked4ma.competitive.common.array.long.d2.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.number.inf.*
import com.github.ked4ma.competitive.common.repeat.range.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, M) = nextIntList()
    val arr = sized2DLongArray(N + 1, N + 1, LONG_INF)
    for (i in range(N + 1)) arr[i][i] = 0
    repeat(M) {
        val (A, B, C) = nextIntList().let { (A, B, C) -> Triple(A - 1, B - 1, C.toLong()) }
        arr[A][B] = min(arr[A][B], C)
        arr[B][A] = min(arr[B][A], C)
    }
    val (K, T) = nextIntList().let { (K, T) -> K to T.toLong() }
    val D = if (K > 0) {
        nextIntList().map { it - 1 }
    } else {
        next()
        emptyList()
    }
    for (u in D) {
        if (arr[u][N] > T) {
            arr[u][N] = T
            arr[N][u] = 0
        }
    }

    _debug_println(arr)

    fun warshallFloyd(k: Int) {
        for (i in range(N + 1)) {
            for (j in range(N + 1)) {
                arr[i][j] = min(arr[i][j], arr[i][k] + arr[k][j])
            }
        }
    }
    for (k in range(N + 1)) {
        warshallFloyd(k)
    }

    val Q = nextInt()
    repeat(Q) {
        val query = nextIntList()
        when (query[0]) {
            1 -> {
                val x = query[1] - 1
                val y = query[2] - 1
                val t = query[3].toLong()
                arr[x][y] = min(arr[x][y], t)
                arr[y][x] = min(arr[y][x], t)
                warshallFloyd(x)
                warshallFloyd(y)
            }

            2 -> {
                val x = query[1] - 1
                if (arr[x][N] > T) {
                    arr[x][N] = T
                    arr[N][x] = 0
                    warshallFloyd(x)
                    warshallFloyd(N)
                }
            }

            3 -> {
                var ans = 0L
                _debug_println(arr)
                _debug_println("====")
                for (i in range(N)) {
                    for (j in range(N)) {
                        if (arr[i][j] < LONG_INF) {
                            ans += arr[i][j]
                        }
                    }
                }
                println(ans)
            }
        }
    }
}
