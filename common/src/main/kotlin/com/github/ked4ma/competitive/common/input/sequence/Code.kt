package com.github.ked4ma.competitive.common.input.sequence

import com.github.ked4ma.competitive.common.input.default.*

fun nextSequence() = next().splitToSequence(" ")
fun nextIntSequence() = nextSequence().map(String::toInt)
fun nextLongSequence() = nextSequence().map(String::toLong)
fun nextULongSequence() = nextSequence().map(String::toULong)
fun nextDoubleSequence() = nextSequence().map(String::toDouble)
