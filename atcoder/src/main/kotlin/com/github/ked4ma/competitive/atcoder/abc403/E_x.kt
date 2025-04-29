package com.github.ked4ma.competitive.atcoder.abc403

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val Q = nextInt()
    val root = Trie()
    var yCount = 0
    val Z = mutableSetOf<Int>()
    val ans = mutableListOf<Int>()
    repeat(Q) { index ->
        val (T, S) = nextList().let { (T, S) -> T.toInt() to S }
        var node = root
        for (i in range(S.length)) {
            node = node.get(S[i])
            if (T == 2) node.words.add(index)
        }
        if (T == 1) {
            node.prefixed = true
            Z.addAll(node.words)
            node.words.clear()
        } else {
            yCount++
            if (node.prefixed) {
                Z.add(index)
            }
        }
        _debug_println(S)
        _debug_println(Z)
        ans.add(yCount - Z.size)
    }
    println(ans.joinToString("\n"))
}

private data class Trie(
    val next: MutableMap<Char, Trie> = mutableMapOf(),
    var prefixed: Boolean = false,
    val words: MutableSet<Int> = mutableSetOf()
) {
    fun get(c: Char): Trie {
        next.putIfAbsent(c, Trie())
        val res = next.getValue(c)
        if (this.prefixed) res.prefixed = true
        return next.getValue(c)
    }
}
