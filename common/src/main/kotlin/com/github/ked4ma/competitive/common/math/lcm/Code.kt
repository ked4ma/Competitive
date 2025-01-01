package com.github.ked4ma.competitive.common.math.lcm

import com.github.ked4ma.competitive.common.math.gcd.*

// a * b = lcm(a, b) * gcd(a, b)
fun lcm(a: Long, b: Long): Long {
    return a / gcd(a, b) * b
}