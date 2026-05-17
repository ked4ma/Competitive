package com.github.ked4ma.competitive.common.models.cumlative.d2sum

class CumulativeSum2D {
    private val h: Int
    private val w: Int
    val data: Array<LongArray>

    // NOTE: only use for one time initialization.
    // If need to recreate several time, use set and build func.
    constructor(arr: Array<Array<out Number>>) : this(arr.size, arr.first().size) {
        for (i in 0 until h) {
            for (j in 0 until w) {
                data[i + 1][j + 1] = data[i][j + 1] + data[i + 1][j] - data[i][j] + arr[i][j].toLong()
            }
        }
    }

    constructor(arr: Array<IntArray>) : this(arr.size, arr.first().size) {
        for (i in 0 until h) {
            for (j in 0 until w) {
                data[i + 1][j + 1] = data[i][j + 1] + data[i + 1][j] - data[i][j] + arr[i][j]
            }
        }
    }

    constructor(arr: Array<LongArray>) : this(arr.size, arr.first().size) {
        for (i in 0 until h) {
            for (j in 0 until w) {
                data[i + 1][j + 1] = data[i][j + 1] + data[i + 1][j] - data[i][j] + arr[i][j]
            }
        }
    }

    constructor(list: List<List<Number>>) : this(list.size, list.first().size) {
        for (i in 0 until h) {
            for (j in 0 until w) {
                data[i + 1][j + 1] = data[i][j + 1] + data[i + 1][j] - data[i][j] + list[i][j].toLong()
            }
        }
    }

    constructor(h: Int, w: Int) {
        this.h = h
        this.w = w
        data = Array(h + 1) { LongArray(w + 1) { 0L } }
    }

    fun set(h: Int, w: Int, n: Number) {
        data[h + 1][w + 1] = n.toLong()
    }

    fun add(h: Int, w: Int, n: Number) {
        data[h + 1][w + 1] += n.toLong()
    }

    fun build() {
        for (i in 0 until h) {
            for (j in 0 until w) {
                data[i + 1][j + 1] = data[i][j + 1] + data[i + 1][j] - data[i][j] + data[i + 1][j + 1]
            }
        }
    }

    // get sum
    // NOTE: [startX,endX], [startY,endY]
    //   sections are all inclusive
    // @Deprecated(
    //     "use sumOf(...) instead",
    //     replaceWith = ReplaceWith("this.sumOf(startX, startY, endX + 1, endY + 1)")
    // )
    fun getSumOf(startX: Int, startY: Int, endX: Int, endY: Int): Long =
        data[endY + 1][endX + 1] - data[endY + 1][startX] - data[startY][endX + 1] + data[startY][startX]

    // get sum
    // NOTE:
    //   (startX,endX): inclusive
    //   (startY,endY): exclusive
    fun sumOf(sx: Int, sy: Int, ex: Int, ey: Int): Long =
        data[ey][ex] - data[ey][sx] - data[sy][ex] + data[sy][sy]

    // get sum of the rectagle of (0,0) -> (x,y)
    // NOTE:
    //   (x, y): exclusive
    fun sumOf(x: Int, y: Int): Long = data[y][x]
}
