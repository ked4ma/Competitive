package com.github.ked4ma.competitive.atcoder.abc426

import com.github.ked4ma.competitive.common.input.default.*
import kotlin.math.abs
import kotlin.math.min
import kotlin.math.pow
import kotlin.math.sqrt

// make run <TASK: A/B/...> [BRANCH=contest/<CONTEST: abc000>]
fun main() {
    // POINT: relative position
    val T = nextInt()
    repeat(T) {
        solve()
    }
}

private fun solve() {
    var t = nextDoubleList().let { (sx, sy, tx, ty) -> Line(Vec(sx, sy), Vec(tx, ty)) }
    var a = nextDoubleList().let { (sx, sy, tx, ty) -> Line(Vec(sx, sy), Vec(tx, ty)) }
    if (t.norm() < a.norm()) {
        t = a.also { a = t }
    }
    val tLen = t.norm()
    val aLen = a.norm()
    var ans = Double.MAX_VALUE
    run {
        val l = Line(t.s - a.s, t.divpoint(aLen / tLen) - a.t)
        ans = min(ans, l.distSP(Vec(0.0, 0.0)))
    }
    run {
        val l = Line(t.divpoint(aLen / tLen) - a.t, t.t - a.t)
        ans = min(ans, l.distSP(Vec(0.0, 0.0)))
    }
    println(ans)
}

private const val EPS = 0.000000001

private data class Line(val s: Vec, val t: Vec) {
    fun norm() = (t - s).norm()
    fun divpoint(p: Double) = s * (1 - p) + t * p
    fun distSP(p: Vec): Double {
        if ((p - s).dot(t - s) < EPS) {
            return (s - p).norm()
        } else if ((p - t).dot(s - t) < EPS) {
            return (t - p).norm()
        }
        return abs((s - p).cross(t - p)) / (t - s).norm()
    }
}

private data class Vec(val x: Double, val y: Double) {
    operator fun plus(v: Vec) = Vec(x + v.x, y + v.y)
    operator fun minus(v: Vec) = Vec(x - v.x, y - v.y)
    operator fun times(v: Double) = Vec(x * v, y * v)

    fun dot(v: Vec) = x * v.x + y * v.y
    fun cross(v: Vec) = x * v.y - y * v.x

    fun norm() = sqrt(x.pow(2) + y.pow(2))
}
