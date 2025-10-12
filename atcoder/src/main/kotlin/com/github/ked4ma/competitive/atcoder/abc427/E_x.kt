package com.github.ked4ma.competitive.atcoder.abc427

import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*
import kotlin.math.max
import kotlin.math.min

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W) = nextIntList()
    val S = times(H) { nextCharArray() }
    val (si, sj) = run {
        for (h in 0 until H) {
            for (w in 0 until W) {
                if (S[h][w] == 'T') {
                    S[h][w] = '.'
                    return@run h to w
                }
            }
        }
        return@run 0 to 0
    }
    val dist = mutableMapOf<State, Int>()
    val queue = ArrayDeque<State>()
    fun push(li: Int, ri: Int, lj: Int, rj: Int, ti: Int, tj: Int, d: Int) {
        val nli = max(li, ti - si)
        val nri = min(ri, H + (ti - si))
        val nlj = max(lj, tj - sj)
        val nrj = min(rj, W + (tj - sj))
        if (ti in nli until nri && tj in nlj until nrj && S[ti][tj] == '#') return
        val st = State(nli, nri, nlj, nrj, ti, tj)
        if (st in dist) return
        dist[st] = d
        queue.add(st)
    }
    push(0, H, 0, W, si, sj, 0)
    while (queue.isNotEmpty()) {
        val d = dist.getValue(queue.first())
        val (li: Int, ri: Int, lj: Int, rj: Int, ti: Int, tj: Int) = queue.removeFirst()

        run {
            var cnt = 0
            for (i in li until ri) {
                for (j in lj until rj) {
                    if (S[i][j] == '#') cnt++
                }
            }
            if (cnt == 0) {
                println(d)
                return
            }
        }

        push(li, ri, lj, rj, ti - 1, tj, d + 1)
        push(li, ri, lj, rj, ti + 1, tj, d + 1)
        push(li, ri, lj, rj, ti, tj - 1, d + 1)
        push(li, ri, lj, rj, ti, tj + 1, d + 1)
    }
    println(-1)
}

private data class State(val li: Int, val ri: Int, val lj: Int, val rj: Int, val ti: Int, val tj: Int)
