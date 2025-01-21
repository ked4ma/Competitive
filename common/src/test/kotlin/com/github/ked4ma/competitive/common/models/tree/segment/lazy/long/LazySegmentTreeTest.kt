package com.github.ked4ma.competitive.common.models.tree.segment.lazy.long

import com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.raq.max.*
import com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.raq.min.*
import com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.raq.sum.*
import com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.ruq.max.*
import com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.ruq.min.*
import com.github.ked4ma.competitive.common.models.tree.segment.lazy.long.ruq.sum.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LazySegmentTreeTest {
    private val n = 16L
    private val data = (1..n).toList()

    @Test
    fun test_RUQ_RMQ() { // update + max(query)
        val segTree = LazySegmentTree.RUQ_RMQ(data.size)
        segTree.init(data)
        assertEquals(5L, segTree.query(1, 5))
        assertEquals(8L, segTree.query(6, 8))
        assertEquals(7L, segTree.query(0, 7))
        segTree.update(1, 7, 10)
        assertEquals(1, segTree.query(0, 1))
        assertEquals(10, segTree.query(1, 2))

        assertEquals(10, segTree.query(0, 9))
        assertEquals(11, segTree.query(0, 11))
        assertEquals(8, segTree.query(7, 8))
        segTree.update(0, 6, 10)
        assertEquals(10, segTree.query(0, 1))
        assertEquals(10, segTree.query(1, 2))
        assertEquals(10, segTree.query(2, 3))
        assertEquals(10, segTree.query(3, 4))
        assertEquals(10, segTree.query(4, 5))
        assertEquals(10, segTree.query(5, 6))
        assertEquals(10, segTree.query(6, 7))
        assertEquals(8, segTree.query(7, 8))
    }

    @Test
    fun test_RUQ_RmQ() { // update + min(query)
        val segTree = LazySegmentTree.RUQ_RmQ(data.size)
        segTree.init(data)
        assertEquals(2L, segTree.query(1, 5))
        assertEquals(7L, segTree.query(6, 8))
        assertEquals(1L, segTree.query(0, 7))
        segTree.update(1, 7, 10)
        assertEquals(1, segTree.query(0, 1))
        assertEquals(10, segTree.query(1, 2))
        assertEquals(8, segTree.query(2, 9))
        assertEquals(1, segTree.query(0, 11))
        assertEquals(8, segTree.query(7, 8))
        segTree.update(0, 6, 10)
        assertEquals(10, segTree.query(0, 1))
        assertEquals(10, segTree.query(1, 2))
        assertEquals(10, segTree.query(2, 3))
        assertEquals(10, segTree.query(3, 4))
        assertEquals(10, segTree.query(4, 5))
        assertEquals(10, segTree.query(5, 6))
        assertEquals(10, segTree.query(6, 7))
        assertEquals(8, segTree.query(7, 8))
    }

    @Test
    fun test_RUQ_RSQ() { // update + sum(query)
        val segTree = LazySegmentTree.RUQ_RSQ(data.size)
        segTree.init(data)
        assertEquals(14L, segTree.query(1, 5))
        assertEquals(15L, segTree.query(6, 8))
        assertEquals(28L, segTree.query(0, 7))
        segTree.update(1, 7, 10)
        assertEquals(1L, segTree.query(0, 1))
        assertEquals(10L, segTree.query(1, 2))
        assertEquals(10L, segTree.query(2, 3))
        assertEquals(10L, segTree.query(3, 4))
        assertEquals(10L, segTree.query(4, 5))
        assertEquals(10L, segTree.query(5, 6))
        assertEquals(10L, segTree.query(6, 7))
        assertEquals(8L, segTree.query(7, 8))
        assertEquals(9L, segTree.query(8, 9))
        assertEquals(78L, segTree.query(0, 9))
        assertEquals(99L, segTree.query(0, 11))
        assertEquals(8L, segTree.query(7, 8))
        segTree.update(0, 6, 10)
        assertEquals(10L, segTree.query(0, 1))
        assertEquals(10L, segTree.query(1, 2))
        assertEquals(10L, segTree.query(2, 3))
        assertEquals(10L, segTree.query(3, 4))
        assertEquals(10L, segTree.query(4, 5))
        assertEquals(10L, segTree.query(5, 6))
        assertEquals(10L, segTree.query(6, 7))
        assertEquals(8L, segTree.query(7, 8))
        assertEquals(28L, segTree.query(5, 8))
    }

    @Test
    fun test_RAQ_RMQ() { // add + max(query)
        val segTree = LazySegmentTree.RAQ_RMQ(data.size)
        segTree.init(data)
        assertEquals(5L, segTree.query(1, 5))
        assertEquals(8L, segTree.query(6, 8))
        assertEquals(7L, segTree.query(0, 7))
        segTree.update(1, 7, 10)
        assertEquals(1L, segTree.query(0, 1))
        assertEquals(12L, segTree.query(1, 2))

        assertEquals(17L, segTree.query(0, 9))
        assertEquals(17L, segTree.query(0, 11))
        assertEquals(8, segTree.query(7, 8))
        segTree.update(0, 6, 10)
        assertEquals(11, segTree.query(0, 1))
        assertEquals(22, segTree.query(1, 2))
        assertEquals(23, segTree.query(2, 3))
        assertEquals(24, segTree.query(3, 4))
        assertEquals(25, segTree.query(4, 5))
        assertEquals(26, segTree.query(5, 6))
        assertEquals(17, segTree.query(6, 7))
        assertEquals(8, segTree.query(7, 8))
    }

    @Test
    fun test_RAQ_RmQ() {
        val segTree = LazySegmentTree.RAQ_RmQ(data.size)
        segTree.init(data)
        assertEquals(2L, segTree.query(1, 5))
        assertEquals(7L, segTree.query(6, 8))
        assertEquals(1L, segTree.query(0, 7))
        segTree.update(1, 7, 10)
        assertEquals(1L, segTree.query(0, 1))
        assertEquals(12L, segTree.query(1, 2))
        assertEquals(8L, segTree.query(2, 9))
        assertEquals(1L, segTree.query(0, 11))
        assertEquals(8L, segTree.query(7, 8))
        segTree.update(0, 6, 10)
        assertEquals(11L, segTree.query(0, 1))
        assertEquals(22L, segTree.query(1, 2))
        assertEquals(23L, segTree.query(2, 3))
        assertEquals(24L, segTree.query(3, 4))
        assertEquals(25L, segTree.query(4, 5))
        assertEquals(26L, segTree.query(5, 6))
        assertEquals(17L, segTree.query(6, 7))
        assertEquals(8L, segTree.query(7, 8))
        assertEquals(8L, segTree.query(5, 8))
    }

    @Test
    fun test_RAQ_RSQ() { // add + sum(query)
        val segTree = LazySegmentTree.RAQ_RSQ(data.size)
        segTree.init(data)
        assertEquals(14L, segTree.query(1, 5))
        assertEquals(15L, segTree.query(6, 8))
        assertEquals(28L, segTree.query(0, 7))
        segTree.update(1, 7, 10)
        assertEquals(1L, segTree.query(0, 1))
        assertEquals(12L, segTree.query(1, 2))
        assertEquals(13L, segTree.query(2, 3))
        assertEquals(14L, segTree.query(3, 4))
        assertEquals(15L, segTree.query(4, 5))
        assertEquals(16L, segTree.query(5, 6))
        assertEquals(17L, segTree.query(6, 7))
        assertEquals(8L, segTree.query(7, 8))
        assertEquals(9L, segTree.query(8, 9))
        assertEquals(105L, segTree.query(0, 9))
        assertEquals(126L, segTree.query(0, 11))
        assertEquals(8L, segTree.query(7, 8))
        segTree.update(0, 6, 10)
        assertEquals(11L, segTree.query(0, 1))
        assertEquals(22L, segTree.query(1, 2))
        assertEquals(23L, segTree.query(2, 3))
        assertEquals(24L, segTree.query(3, 4))
        assertEquals(25L, segTree.query(4, 5))
        assertEquals(26L, segTree.query(5, 6))
        assertEquals(17L, segTree.query(6, 7))
        assertEquals(8, segTree.query(7, 8))
        assertEquals(51L, segTree.query(5, 8))
    }

    @Test
    fun test_maxRight() {
        val segTree = LazySegmentTree.RAQ_RMQ(data.size)
        segTree.init(data)
        // 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16
        //       ↑
        assertEquals(3, segTree.maxRight(0) { it < 4 })

        segTree.update(1, 2)
        segTree.update(2, 1)
        // 1,4,4,4,5,6,7,8,9,10,11,12,13,14,15,16
        //         ↑
        assertEquals(4, segTree.maxRight(0) { it < 5 })
    }

    @Test
    fun test_minLeft() {
        val segTree = LazySegmentTree.RAQ_RmQ(data.size)
        segTree.init(data)
        // 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16
        //                 ↑
        assertEquals(8, segTree.minLeft(data.size) { it >= 9 })

        segTree.update(7, 1)
        // 1,2,3,4,5,6,7,9,9,10,11,12,13,14,15,16
        //               ↑
        assertEquals(7, segTree.minLeft(data.size) { it >= 9 })
    }
}
