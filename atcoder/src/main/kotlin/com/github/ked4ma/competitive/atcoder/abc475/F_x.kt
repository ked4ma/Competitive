package com.github.ked4ma.competitive.atcoder.abc475

import com.github.ked4ma.competitive.common.array.boolean.d1.*
import com.github.ked4ma.competitive.common.array.char.d2.*
import com.github.ked4ma.competitive.common.input.default.*
import com.github.ked4ma.competitive.common.repeat.*

// https://www.youtube.com/live/6-_zUEXoeIs
fun main() {
    var (H, W) = nextIntList()
    var S = times(H) { nextCharArray() }
    if (H > W) {
        H = W.also { W = H }
        val T = sized2DCharArray(H, W, ' ')
        for (h in 0 until H) {
            for (w in 0 until W) {
                T[h][w] = S[w][h]
            }
        }
        S = T.toList()
    }
    // H <= W
    // H <= √(2*10^5)
    // enable to run O(H^2 * W)

    // search bounding box
    var ans = 1L
    for (li in 0 until H) {
        val a = sizedBooleanArray(W)
        for (ri in li until H) {
            for (j in 0 until W) {
                a[j] = a[j] or (S[ri][j] == '.')
            }

            var lj = 0
            var num = 0
            var lx = 0
            var rx = 0
            for (rj in 0 until W) {
                if (S[li][rj] == '.') lx++
                if (S[ri][rj] == '.') rx++
                while (lx > 0 && rx > 0) {
                    if (S[li][lj] == '.') lx--
                    if (S[ri][lj] == '.') rx--
                    num += if (a[lj]) 1 else 0
                    lj++
                }
                if (a[rj]) ans += num
            }
        }
    }
    println(ans)
}
