package com.github.ked4ma.competitive.atcoder.awc0165

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.math.combimation.mod.*
import com.github.ked4ma.competitive.common.math.long.mod.*
import com.github.ked4ma.competitive.common.math.long.pow.*
import com.github.ked4ma.competitive.common.math.mod.*
import com.github.ked4ma.competitive.common.models.unionfind.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    MOD = MOD998244353
    val (N, K, M) = nextIntList()
    val uf = UnionFind(K)
    repeat(M) {
        val (u, v) = nextIntList().map { it - 1 }
        uf.unite(u, v)
    }
    val k = uf.size
    _debug_println(k)

    if (k < N) {
        println(0)
        return
    }

    val comb = CombinationMod(N)
    var ans = 0L
    for (i in 0..N) {
        ans += (-1L).pow(i).timesMod(comb.aCb(N, i) % MOD).timesMod((N - i).toLong().powMod(k.toLong()) % MOD)
        ans %= MOD
    }
    println(ans)
}
