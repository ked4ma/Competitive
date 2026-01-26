package com.github.ked4ma.competitive.common.math.vec.long

import kotlin.math.sqrt

data class LongVec(val x: Long, val y: Long) {
    operator fun plus(v: LongVec) = LongVec(x + v.x, y + v.y)
    operator fun minus(v: LongVec) = LongVec(x - v.x, y - v.y)
    fun times(v: Long) = LongVec(x * v, y * v)

    fun dot(v: LongVec) = x * v.x + y * v.y
    fun cross(v: LongVec) = x * v.y - y * v.x
    fun norm() = sqrt((x * x + y * y).toDouble())
}
