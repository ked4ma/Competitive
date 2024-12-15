package com.github.ked4ma.competitive.atcoder.abc384

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val p = nextIntList()

    val list = mutableListOf<Pair<String, Int>>()
    fun dfs(i: Int = 0, name: String = "", score: Int = 0) {
        if (i == 5) {
            if (name.isEmpty()) return
            list.add(name to score)
            return
        }
        dfs(i + 1, name + ('A' + i), score + p[i])
        dfs(i + 1, name, score)
    }
    dfs()

    println(list.sortedWith(compareBy({ -it.second }, { it.first })).joinToString("\n") { it.first })
}
