package com.github.ked4ma.competitive.common.acl.internal.csr

import kotlin.test.Test
import kotlin.test.assertContentEquals

class CSRTest {
    @Test
    fun test_initialize_instance() {
        val n = 7
        val E = listOf(
            3 to 2,
            0 to 1,
            1 to 2,
            1 to 3,
            4 to 5,
            2 to 5,
            4 to 6,
            6 to 5,
            0 to 4,
        )

        val csr = CSR(n, E)
        assertContentEquals(csr.start, intArrayOf(0, 2, 4, 5, 6, 8, 8, 9))
        assertContentEquals(csr.elist, arrayOf(1, 4, 2, 3, 5, 2, 5, 6, 5))
    }

    @Test
    fun test_initialize_instance_edge_object() {
        data class Edge(val n: Int)

        val n = 7
        val E = listOf(
            3 to Edge(2),
            0 to Edge(1),
            1 to Edge(2),
            1 to Edge(3),
            4 to Edge(5),
            2 to Edge(5),
            4 to Edge(6),
            6 to Edge(5),
            0 to Edge(4),
        )

        val csr = CSR(n, E)
        assertContentEquals(csr.start, intArrayOf(0, 2, 4, 5, 6, 8, 8, 9))
        assertContentEquals(
            csr.elist,
            arrayOf(
                Edge(1),
                Edge(4),
                Edge(2),
                Edge(3),
                Edge(5),
                Edge(2),
                Edge(5),
                Edge(6),
                Edge(5),
            )
        )
    }
}