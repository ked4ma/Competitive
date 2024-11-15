package com.github.ked4ma.competitive.common.list.long.cumlative

fun List<Long>.cumulativeSum(): List<Long> = this.scan(0L) { acc, l -> acc + l }