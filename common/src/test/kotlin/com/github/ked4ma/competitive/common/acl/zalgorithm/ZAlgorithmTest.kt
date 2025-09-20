package com.github.ked4ma.competitive.common.acl.zalgorithm

import com.github.ked4ma.competitive.common.acl.zalgorithm.array.char.*
import com.github.ked4ma.competitive.common.acl.zalgorithm.array.int.*
import com.github.ked4ma.competitive.common.acl.zalgorithm.general.*
import com.github.ked4ma.competitive.common.acl.zalgorithm.string.*
import org.junit.jupiter.api.Nested
import kotlin.test.Test
import kotlin.test.assertContentEquals

class ZAlgorithmTest {
    @Nested
    inner class List {
        @Test
        fun test_algorithm() {
            val za = listOf(
                "hoge", "huga", "hoge", "huga", "hoge", "huga", "foo", "bar",
                "hoge", "huga", "hoge", "huga", "hoge", "huga", "foo", "bar",
            ).zAlgorithm()

            assertContentEquals(
                intArrayOf(16, 0, 4, 0, 2, 0, 0, 0, 8, 0, 4, 0, 2, 0, 0, 0, 0),
                za,
            )
        }
    }

    @Nested
    inner class CharArray {
        @Test
        fun test_algorithm() {
            val za = charArrayOf(
                'm', 'o', 'm', 'o', 'm', 'o', 's', 'u',
                'm', 'o', 'm', 'o', 'm', 'o', 's', 'u',
            ).zAlgorithm()

            assertContentEquals(
                intArrayOf(16, 0, 4, 0, 2, 0, 0, 0, 8, 0, 4, 0, 2, 0, 0, 0, 0),
                za,
            )
        }
    }

    @Nested
    inner class IntArray {
        @Test
        fun test_algorithm() {
            val za = intArrayOf(
                1, 2, 1, 2, 1, 2, 3, 4,
                1, 2, 1, 2, 1, 2, 3, 4,
            ).zAlgorithm()

            assertContentEquals(
                intArrayOf(16, 0, 4, 0, 2, 0, 0, 0, 8, 0, 4, 0, 2, 0, 0, 0, 0),
                za,
            )
        }
    }

    @Nested
    inner class String {
        @Test
        fun test_algorithm() {
            val za = "momomosumomomosu".zAlgorithm()

            assertContentEquals(
                intArrayOf(16, 0, 4, 0, 2, 0, 0, 0, 8, 0, 4, 0, 2, 0, 0, 0, 0),
                za,
            )
        }
    }
}
