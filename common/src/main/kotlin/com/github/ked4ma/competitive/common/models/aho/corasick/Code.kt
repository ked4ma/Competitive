package com.github.ked4ma.competitive.common.models.aho.corasick

import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.debug.*

// https://www.youtube.com/watch?v=BYoRvdgI5EU&t=9633s
class AhoCorasick {
    private val G = mutableListOf(mutableMapOf<Char, Int>())
    private val cnt = mutableListOf(0)
    private lateinit var fail: IntArray
    val size: Int
        get() = G.size

    fun add(s: String): Int {
        var cur = 0
        for (c in s) {
            if (c !in G[cur]) {
                G[cur][c] = G.size
                G.add(mutableMapOf())
                cnt.add(0)
            }
            cur = G[cur].getValue(c)
        }
        cnt[cur] = cnt[cur] + 1
        return cur
    }

    fun build() {
        fail = sizedIntArray(G.size, -1)

        val q = ArrayDeque<Int>()
        q.add(0)
        while (q.isNotEmpty()) {
            val u = q.removeFirst()
            for ((c, v) in G[u]) {
                fail[v] = next(fail[u], c)
                cnt[v] += cnt[fail[v]]
                q.add(v)
            }
        }
        _debug_println(cnt)
    }

    // calc next node from "u" when next char is "c"
    fun next(u: Int, c: Char): Int {
        var cur = u
        while (cur != -1) {
            val t = G[cur][c]
            if (t != null) return t
            cur = fail[cur]
        }
        return 0
    }

    // count that finish word at this point.
    // we can use this for judging this index can be end of word.
    //
    // if there are following words
    // - she
    // - he
    // cnt[node("s" -> "h" -> "e")] = 2
    fun cnt(index: Int): Int = cnt[index]
}
