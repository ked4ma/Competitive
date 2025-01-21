package com.github.ked4ma.competitive.common.number.int.bit.ceil

// return min value "X >= value"
fun Int.bitCeil(): Int {
    //     unsigned int x = 1;
    //    while (x < (unsigned int)(n)) x *= 2;
    //    return x;
    var res = 1
    while (res < this) res *= 2
    return res
}