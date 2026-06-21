package com.github.ked4ma.competitive.common.models.tree.cartesian

import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class CartesianTreeTest {
    @Test
    fun test_max() {
        val tree = CartesianTree(listOf(3, 1, 4, 2, 6, 5))

        assertEquals(4, tree.rootIndex)
        assertContentEquals(intArrayOf(-1, -1, 0, -1, 2, -1), tree.l)
        assertContentEquals(intArrayOf(1, -1, 3, -1, 5, -1), tree.r)
    }

    @Test
    fun test_min() {
        val tree = CartesianTree(listOf(3, 1, 4, 2, 6, 5), max = false)

        assertEquals(1, tree.rootIndex)
        assertContentEquals(intArrayOf(-1, 0, -1, 2, -1, 4), tree.l)
        assertContentEquals(intArrayOf(-1, 3, -1, 5, -1, -1), tree.r)
    }
}
