package com.github.roosale.ctcipractice

import com.github.roosale.ctcipractice.vii.Tree
import org.junit.Assert.*
import org.junit.Test

class TreeUnitTest {

    //          2
    //         / \
    //        1   3
    private val balanced = Tree().apply {
        insert(2)
        insert(1)
        insert(3)
    }

    //          1
    //           \
    //            2
    //             \
    //              3
    private val unbalanced = Tree().apply {
        insert(1)
        insert(2)
        insert(3)
    }

    @Test
    fun `pre-order - balanced`() = assertEquals(balanced.preOrder, "[2, 1, 3]")

    @Test
    fun `pre-order - unbalanced`() = assertEquals(unbalanced.preOrder, "[1, 2, 3]")

    @Test
    fun `in-order - balanced`() = assertEquals(balanced.inOrder, "[1, 2, 3]")

    @Test
    fun `in-order - unbalanced`() = assertEquals(unbalanced.inOrder, "[1, 2, 3]")

    @Test
    fun `post-order - balanced`() = assertEquals(balanced.postOrder, "[1, 3, 2]")

    @Test
    fun `post-order - unbalanced`() = assertEquals(unbalanced.postOrder, "[3, 2, 1]")

    @Test
    fun `contains - balanced`() = balanced.run {
        assertFalse(contains(0))
        assertTrue(contains(1))
        assertTrue(contains(2))
        assertTrue(contains(3))
        assertFalse(contains(4))
    }

    @Test
    fun `contains - unbalanced`() = unbalanced.run {
        assertFalse(contains(0))
        assertTrue(contains(1))
        assertTrue(contains(2))
        assertTrue(contains(3))
        assertFalse(contains(4))
    }

    @Test
    fun  `balance - unbalanced`() = unbalanced.run {
        balance()
        assertEquals(preOrder, "[2, 1, 3]")
        assertEquals(inOrder, "[1, 2, 3]")
        assertEquals(postOrder, "[1, 3, 2]")
    }

}