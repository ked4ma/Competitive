package com.github.ked4ma.competitive.common.number.int.bit

infix fun Int.bit(i: Int) = (this shr i) and 1 == 1
infix fun Int.bitAt(i: Int) = (this shr i) and 1