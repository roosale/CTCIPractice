package com.github.roosale.ctcipractice

import com.github.roosale.ctcipractice.vii.LinkedList
import org.junit.Assert.assertEquals
import org.junit.Test

class LinkedListUnitTest {

    private val simple: LinkedList<Int>
        get() = LinkedList<Int>().apply {
            append(6)
            append(7)
            append(1)
        }

    @Test
    fun `prepend - simple`() = simple.run {
        prepend(30)
        assertEquals(toString(), "[30, 6, 7, 1]")
    }

    @Test
    fun `append - simple`() = simple.run {
        append(30)
        assertEquals(toString(), "[6, 7, 1, 30]")
    }

    @Test
    fun `add - simple`() = simple.run {
        add(2, 30)
        assertEquals(toString(), "[6, 7, 30, 1]")
    }

    @Test
    fun `get - simple`() = assertEquals(simple.get(2), 1)

    @Test
    fun `removeFirst - simple`() = simple.run {
        removeFirst()
        assertEquals(toString(), "[7, 1]")
    }

    @Test
    fun `removeLast - simple`() = simple.run {
        removeLast()
        assertEquals(toString(), "[6, 7]")
    }

    @Test
    fun `remove - simple`() = simple.run {
        remove(2)
        assertEquals(toString(), "[6, 7]")
    }

    @Test
    fun `clear - simple`() = simple.run {
        clear()
        assertEquals(toString(), "[]")
    }

    @Test
    fun `size - simple`() = assertEquals(simple.size, 3)

}