package com.github.roosale.ctcipractice

import com.github.roosale.ctcipractice.vii.LinkedList
import org.junit.Assert.assertEquals
import org.junit.Test

class LinkedListUnitTest {

    private fun getSimpleList() = LinkedList<Int>().apply {
        addLast(6)
        addLast(7)
        addLast(1)
    }

    @Test
    fun `addFirst - simple`() {
        val list = getSimpleList()
        list.addFirst(30)
        assertEquals(list.toString(), "[30, 6, 7, 1]")
    }

    @Test
    fun `addLast - simple`() {
        val list = getSimpleList()
        list.addLast(30)
        assertEquals(list.toString(), "[6, 7, 1, 30]")
    }

    @Test
    fun `add - simple`() {
        val list = getSimpleList()
        list.add(2, 30)
        assertEquals(list.toString(), "[6, 7, 30, 1]")
    }

    @Test
    fun `get - simple`() {
        val list = getSimpleList()
        assertEquals(list.get(2), 1)
    }

    @Test
    fun `removeFirst - simple`() {
        val list = getSimpleList()
        list.removeFirst()
        assertEquals(list.toString(), "[7, 1]")
    }

    @Test
    fun `removeLast - simple`() {
        val list = getSimpleList()
        list.removeLast()
        assertEquals(list.toString(), "[6, 7]")
    }

    @Test
    fun `remove - simple`() {
        val list = getSimpleList()
        list.remove(2)
        assertEquals(list.toString(), "[6, 7]")
    }

    @Test
    fun `clear - simple`() {
        val list = getSimpleList()
        list.clear()
        assertEquals(list.toString(), "[]")
    }

    @Test
    fun `size - simple`() {
        val list = getSimpleList()
        assertEquals(list.size, 3)
    }

}