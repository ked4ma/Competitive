package com.github.ked4ma.competitive.common.number.long.bit.ceil

// return min value "X >= value"
fun Long.bitCeil(): Long {
    //     unsigned int x = 1;
    //    while (x < (unsigned int)(n)) x *= 2;
    //    return x;
    var res = 1L
    while (res < this) res *= 2
    return res
}