package com.github.ked4ma.competitive.atcoder.abc411

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (N, Q) = nextIntList()
    val queries = times(Q) {
        nextList()
    }
    var s = "s"
    val list = mutableListOf<Int>()
    for (i in range(Q).reversed()) {
        val query = queries[i]
        when (query[0]) {
            "1" -> {
                if (s == query[1]) {
                    // list.add(i)
                    s = "s"
                }
            }

            "2" -> {
                if (s == query[1]) {
                    list.add(i)
                }
            }

            "3" -> {
                if (s == "s") {
                    // list.add(i)
                    s = query[1]
                }
            }
        }
    }
    val ans = StringBuilder();
    for (i in list.asReversed()) {
        ans.append(queries[i][2])
    }
    println(ans)
    //var S = listOf<Int>()
    //val PC = sizedArray(N) { mutableListOf<Int>() }
    // for (i in range(Q)) {
    //     val query = queries[i]
    //     val q = query[0]
    //     val p = query[1].toInt() - 1
    //     when (q) {
    //         "1" -> {
    //             PC[p] = S.toMutableList()
    //         }

    //         "2" -> {
    //             PC[p].add(i)
    //         }

    //         "3" -> {
    //             S = PC[p].toList()
    //         }
    //     }
    // }
    // val ans = StringBuilder()
    // for (i in S) {
    //     ans.append(queries[i][2])
    // }
    // println(ans)
}
