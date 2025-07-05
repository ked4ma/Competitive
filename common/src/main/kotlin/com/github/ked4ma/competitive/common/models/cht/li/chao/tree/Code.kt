package com.github.ked4ma.competitive.common.models.cht.li.chao.tree

import com.github.ked4ma.competitive.common.array.any.d1.*
import com.github.ked4ma.competitive.common.list.d1.*
import com.github.ked4ma.competitive.common.math.int.pow.*
import com.github.ked4ma.competitive.common.models.cht.*
import com.github.ked4ma.competitive.common.number.inf.*
import com.github.ked4ma.competitive.common.number.int.bit.length.*
import kotlin.math.min

// ref: https://smijake3.hatenablog.com/entry/2018/06/16/144548
class LiChaoTree(x: List<Long>) : CHT {
    private val N = x.size
    private val N0 = 2.pow((N - 1).bitLength())
    private val X = x + sizedListOf(2 * N0 + 1 - N, x.max() * 10)
    private val data = sizedArray(2 * N0 + 1, Line())

    override fun addLine(a: Long, b: Long) = addLine(Line(a, b), 0, 0, N0)

    private fun addLine(line: Line, k: Int, l: Int, r: Int) {
        val m = (l + r) / 2
        if (data[k] == Line()) {
            data[k] = line
            return
        }
        val lx = X[l]
        val mx = X[m]
        val rx = X[r - 1]
        val left = line.y(lx) < data[k].y(lx)
        val mid = line.y(mx) < data[k].y(mx)
        val right = line.y(rx) < data[k].y(rx)

        if (left && right) {
            data[k] = line
            return
        }
        if (!left && !right) return

        var cur = line
        if (mid) {
            data[k] = cur.also { cur = data[k] }
        }
        if (left != mid) {
            // search [l, m)
            addLine(cur, 2 * k + 1, l, m)
        } else {
            // search [m, r)
            addLine(cur, 2 * k + 2, m, r)
        }
    }

    fun query(k: Int): Long {
        val x = X[k]
        var i = k + N0 - 1
        var res = LONG_INF
        while (i >= 0) {
            if (data[i] != Line()) {
                res = min(res, data[i].y(x))
            }
            if (i == 0) break
            i = (i - 1) / 2
        }
        return res
    }

    private data class Line(val a: Long = 0, val b: Long = LONG_INF) {
        fun y(x: Long) = a * x + b
    }
}
