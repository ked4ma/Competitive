package com.github.ked4ma.competitive.atcoder.abc453

import com.github.ked4ma.competitive.common.array.int.d3.*
import com.github.ked4ma.competitive.common.debug.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    val (H, W) = nextIntList()
    var (sh, sw, gh, gw) = listOf(0, 0, 0, 0)
    val S = times(H) { h ->
        val s = nextCharArray()
        val si = s.indexOf('S')
        val gi = s.indexOf('G')
        if (si >= 0) {
            sh = h
            sw = si
        }
        if (gi >= 0) {
            gh = h
            gw = gi
        }
        s
    }
    _debug_println("($sh, $sw) -> ($gh, $gw)")
    _debug_println(S)
    _debug_println("----")

    val dh = arrayOf(1, 0, -1, 0)
    val dw = arrayOf(0, 1, 0, -1)
    val dn = arrayOf('D', 'R', 'U', 'L')

    data class D(val h: Int, val w: Int, val di: Int, val step: Int)

    val queue = ArrayDeque<D>()
    val vis = sized3DIntArray(H, W, 4, -1)

    fun push(h: Int, w: Int, di: Int, step: Int) {
        if (vis[h][w][di] >= 0) return
        vis[h][w][di] = step
        queue.add(D(h, w, di, step))
    }

    fun restore() {
        var h = gh
        var w = gw
        var di = vis[h][w].indexOfFirst { it >= 0 }
        var step = vis[h][w][di]
        di = 5
        _debug_println(step)
        val sb = StringBuilder()
        while (h != sh || w != sw) {
            val dirs = when (S[h][w]) {
                'o' -> listOf(di)
                'x' -> (0 until 4).filterNot { it == di }
                else -> (0 until 4).toList()
            }
            for (ndi in dirs) {
                if (vis[h][w][ndi] == step) {
                    sb.append(dn[ndi])
                    h += dh[(ndi + 2) % 4]
                    w += dw[(ndi + 2) % 4]
                    di = ndi
                    step--
                    break
                }
            }
        }
        println(sb.reversed())
    }

    (0 until 4).forEach { push(sh, sw, it, 0) }
    while (queue.isNotEmpty()) {
        val (h, w, di, step) = queue.removeFirst()
        if (h == gh && w == gw) {
            println("Yes")
            restore()
            return
        }
        val c = S[h][w]
        val dirs = when (c) {
            'o' -> listOf(di)
            'x' -> (0 until 4).filterNot { it == di }
            else -> (0 until 4).toList()
        }
        for (ndi in dirs) {
            val nh = h + dh[ndi]
            val nw = w + dw[ndi]
            if (nh !in 0 until H || nw !in 0 until W || S[nh][nw] == '#' || vis[nh][nw][ndi] >= 0) continue
            push(nh, nw, ndi, step + 1)
        }
    }
    println("No")
}
