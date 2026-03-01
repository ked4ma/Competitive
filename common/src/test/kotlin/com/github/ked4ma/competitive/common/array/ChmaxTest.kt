package com.github.ked4ma.competitive.common.array

import com.github.ked4ma.competitive.common.array.double.d1.*
import com.github.ked4ma.competitive.common.array.double.d1.chmax.*
import com.github.ked4ma.competitive.common.array.double.d2.*
import com.github.ked4ma.competitive.common.array.double.d2.chmax.*
import com.github.ked4ma.competitive.common.array.double.d3.*
import com.github.ked4ma.competitive.common.array.double.d3.chmax.*
import com.github.ked4ma.competitive.common.array.int.d1.*
import com.github.ked4ma.competitive.common.array.int.d1.chmax.*
import com.github.ked4ma.competitive.common.array.int.d2.*
import com.github.ked4ma.competitive.common.array.int.d2.chmax.*
import com.github.ked4ma.competitive.common.array.int.d3.*
import com.github.ked4ma.competitive.common.array.int.d3.chmax.*
import com.github.ked4ma.competitive.common.array.long.d1.*
import com.github.ked4ma.competitive.common.array.long.d1.chmax.*
import com.github.ked4ma.competitive.common.array.long.d2.*
import com.github.ked4ma.competitive.common.array.long.d2.chmax.*
import com.github.ked4ma.competitive.common.array.long.d3.*
import com.github.ked4ma.competitive.common.array.long.d3.chmax.*
import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class ChmaxTest {
    @Test
    fun test_intArray() {
        val arr = sizedIntArray(5, 1)
        arr.chmax(3, 4)

        assertContentEquals(
            intArrayOf(1, 1, 1, 4, 1),
            arr,
        )
    }

    @Test
    fun test_int2DArray() {
        val arr = sized2DIntArray(3, 3, 1)
        arr.chmax(1, 2, 4)

        assertEquals(4, arr[1][2])
    }

    @Test
    fun test_int3DArray() {
        val arr = sized3DIntArray(2, 2, 3, 1)
        arr.chmax(0, 1, 2, 4)

        assertEquals(4, arr[0][1][2])
    }

    @Test
    fun test_longArray() {
        val arr = sizedLongArray(5, 1)
        arr.chmax(3, 4)

        assertContentEquals(
            longArrayOf(1, 1, 1, 4, 1),
            arr,
        )
    }

    @Test
    fun test_long2DArray() {
        val arr = sized2DLongArray(3, 3, 1)
        arr.chmax(1, 2, 4)

        assertEquals(4, arr[1][2])
    }

    @Test
    fun test_long3DArray() {
        val arr = sized3DLongArray(2, 2, 3, 1)
        arr.chmax(0, 1, 2, 4)

        assertEquals(4, arr[0][1][2])
    }

    @Test
    fun test_doubleArray() {
        val arr = sizedDoubleArray(5, 1.0)
        arr.chmax(3, 4.0)

        assertContentEquals(
            doubleArrayOf(1.0, 1.0, 1.0, 4.0, 1.0),
            arr,
        )
    }

    @Test
    fun test_double2DArray() {
        val arr = sized2DDoubleArray(3, 3, 1.0)
        arr.chmax(1, 2, 4.0)

        assertEquals(4.0, arr[1][2])
    }

    @Test
    fun test_duble3DArray() {
        val arr = sized3DDoubleArray(2, 2, 3, 1.0)
        arr.chmax(0, 1, 2, 4.0)

        assertEquals(4.0, arr[0][1][2])
    }
}
