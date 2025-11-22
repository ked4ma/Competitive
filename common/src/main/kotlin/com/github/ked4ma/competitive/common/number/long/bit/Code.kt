package com.github.ked4ma.competitive.common.number.long.bit

infix fun Long.bit(i: Int) = (this shr i) and 1L == 1L
infix fun Long.bitAt(i: Int) = ((this shr i) and 1).toInt()
