package com.github.ked4ma.competitive.atcoder.abc421

import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    var (pt, pa) = nextLongList().let { (rt, ct, ra, ca) ->
        P(rt, ct) to P(ra, ca)
    }
    val (_, M, L) = nextLongList().let { (N, M, L) -> Triple(N, M.toInt(), L.toInt()) }
    val S = times(M) {
        nextList().let { (s, a) -> s[0] to a.toLong() }
    } + listOf('_' to 0L)
    val T = times(L) {
        nextList().let { (t, b) -> t[0] to b.toLong() }
    } + listOf('_' to 0L)
    val ST = buildList {
        var m = 0
        var l = 0
        var (s, a) = S[m]
        var (t, b) = T[l]
        while (m < M && l < L) {
            val len = min(a, b)
            add(D(s, t, len))
            a -= len
            b -= len
            if (a == 0L) {
                m++
                S[m].let { (ns, na) ->
                    s = ns
                    a = na
                }
            }
            if (b == 0L) {
                l++
                T[l].let { (nt, nb) ->
                    t = nt
                    b = nb
                }
            }
        }
    }
    _debug_println(ST)

    val dirs = mapOf(
        'U' to (-1 to 0),
        'D' to (1 to 0),
        'L' to (0 to -1),
        'R' to (0 to 1),
    )

    fun next(p: P, d: Char, len: Long): P {
        val (dr, dc) = dirs.getValue(d)
        val nr = p.r + dr * len
        val nc = p.c + dc * len
        return P(nr, nc)
    }

    fun isCross(pt: P, pa: P, dt: Pair<Int, Int>, da: Pair<Int, Int>, len: Long): Boolean {
        if (dt.first == da.first && dt.second == da.second) return false
        val t = if (dt.first != da.first) {
            if ((pa.r - pt.r) % (dt.first - da.first) != 0L) return false
            (pa.r - pt.r) / (dt.first - da.first)
        } else {
            if ((pa.c - pt.c) % (dt.second - da.second) != 0L) return false
            (pa.c - pt.c) / (dt.second - da.second)
        }
        if (t !in 1..len) return false
        return pt.r + dt.first * t == pa.r + da.first * t && pt.c + dt.second * t == pa.c + da.second * t

//        _debug_println(t)
//        return (t in 1..len)

//        if ((pa.r - pt.r) % (dt.first - da.first) != 0L) return false
//        if ((pa.c - pt.c) % (dt.first - da.first) != 0L) return false
//        var s = (pt.r - npt.r) * (pa.c - pt.c) - (pt.c - npt.c) * (pa.r - pt.r)
//        var t = (pt.r - npt.r) * (npa.c - pt.c) - (pt.c - npt.c) * (npa.r - pt.r)
//        if (s * t > 0) return false
//
//        s = (pa.r - npa.r) * (pt.c - pa.c) - (pa.c - npa.c) * (pt.r - pa.r)
//        t = (pa.r - npa.r) * (npt.c - pa.c) - (pa.c - npa.c) * (npt.r - pa.r)
//        if (s * t > 0) return false
//        return true
    }

    var ans = 0L
    for ((s, t, len) in ST) {
        val npt = next(pt, s, len)
        val npa = next(pa, t, len)
        if (pt.r == pa.r && pt.c == pa.c && npt.r == npa.r && npt.c == npa.c) {
            ans += len
        } else if (s == t) {
            // do nothing
        } else if (isCross(pt, pa, dirs.getValue(s), dirs.getValue(t), len)) {
            ans++
        }
        pt = npt
        pa = npa
    }
    println(ans)
}

private data class P(val r: Long, val c: Long)
private data class D(val s: Char, val t: Char, val len: Long)

