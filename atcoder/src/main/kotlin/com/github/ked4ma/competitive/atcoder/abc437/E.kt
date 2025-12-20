package com.github.ked4ma.competitive.atcoder.abc437

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.input.default.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val N = nextInt()
    val G = sizedArray(N + 1) { mutableListOf<Pair<Int, Int>>() }
    val indexMap = mutableMapOf<Pair<Int, Int>, Int>()
    val indexRevMap = mutableMapOf<Int, MutableList<Int>>()
    val indexArr = sizedIntArray(N + 1) { it }
    repeat(N) {
        val i = it + 1
        val (x, y) = nextIntList().let { (x, y) -> indexArr[x] to y }
        if (x to y !in indexMap) {
            indexMap[x to y] = indexMap.size + 1
            val j = indexMap.getValue(x to y)
            G[x].add(j to y)
            indexRevMap[j] = mutableListOf()
        }
        val j = indexMap.getValue(x to y)
        indexArr[i] = j
        indexRevMap.getValue(j).add(i)
    }
    val ans = mutableListOf<Int>()
    fun dfs(u: Int = 0) {
        for ((v, _) in G[u].sortedBy { it.second }) {
            ans.addAll(indexRevMap.getValue(v))
            dfs(v)
        }
    }
    dfs()
    println(ans.joinToString(" "))
}
