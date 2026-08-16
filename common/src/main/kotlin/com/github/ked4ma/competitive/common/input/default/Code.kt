package com.github.ked4ma.competitive.common.input.default

// ## Input
fun next() = readln()
fun nextCharArray() = next().toCharArray()
fun nextInt() = readln().toInt()
fun nextLong() = next().toLong()
fun nextDouble() = next().toDouble()

fun nextList() = next().split(" ")
fun nextIntList() = nextList().map(String::toInt)
fun nextLongList() = nextList().map(String::toLong)
fun nextULongList() = nextList().map(String::toULong)
fun nextDoubleList() = nextList().map(String::toDouble)
