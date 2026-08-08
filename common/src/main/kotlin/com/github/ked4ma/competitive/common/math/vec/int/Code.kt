package com.github.ked4ma.competitive.common.math.vec.int

import kotlin.math.sqrt

data class IntVec(val x: Int, val y: Int) {
    operator fun plus(v: IntVec) = IntVec(x + v.x, y + v.y)
    operator fun minus(v: IntVec) = IntVec(x - v.x, y - v.y)
    operator fun times(v: Int) = IntVec(x * v, y * v)

    fun dot(v: IntVec) = x * v.x + y * v.y
    fun cross(v: IntVec) = x * v.y - y * v.x
    fun norm() = sqrt((x * x + y * y).toDouble())
    fun rotate90() = IntVec(y, -x)
}
