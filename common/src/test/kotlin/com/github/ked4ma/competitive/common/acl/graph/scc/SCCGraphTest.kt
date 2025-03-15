package com.github.ked4ma.competitive.common.acl.graph.scc

import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class SCCGraphTest {
    @Test
    fun test_create_scc() {
        val (N, M) = 6 to 7
        val UV = listOf(
            1 to 4,
            5 to 2,
            3 to 0,
            5 to 5,
            4 to 1,
            0 to 3,
            4 to 2,
        )

        val sccGraph = SCCGraph(N)
        repeat(M) {
            val (U, V) = UV[it]
            sccGraph.addEdge(U, V)
        }
        val groups = sccGraph.scc()

        assertEquals(4, groups.size)
        assertContentEquals(
            groups,
            arrayOf(
                listOf(5),
                listOf(1, 4),
                listOf(2),
                listOf(0, 3),
            )
        )
    }
}