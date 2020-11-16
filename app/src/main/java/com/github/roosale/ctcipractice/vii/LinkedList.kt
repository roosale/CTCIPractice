package com.github.roosale.ctcipractice.vii

class LinkedList<T: Any>(
    private var head: Node<T>? = null
) {

    class Node<T>(
        var data: T,
        var next: Node<T>? = null
    )

    // O(1)
    fun addFirst(data: T) {
        val node = Node(data)
        node.next = head
        head = node
    }

    // O(n)
    fun addLast(data: T) {
        var pointer = head

        if (pointer == null) {
            head = Node(data)
            return
        }

        while (pointer?.next != null) {
            pointer = pointer.next
        }

        pointer?.next = Node(data)
    }

    // O(n)
    fun add(index: Int, data: T) {
        val size = size

        if (index == 0) {
            addFirst(data)
            return
        }

        if (index == size) {
            addLast(data)
            return
        }

        if ((index < 0) || (size < index)) {
            throw IllegalArgumentException("invalid, index out of bounds")
        }

        var pointer = head
        var count = index

        while (count-- > 1) {
            pointer = pointer!!.next
        }

        val node = Node(data)
        node.next = pointer?.next
        pointer?.next = node
    }

    // O(n)
    fun get(index: Int): T {
        if ((index < 0) || (size <= index)) {
            throw IllegalArgumentException("invalid, index out of bounds")
        }

        var pointer = head
        var count = index

        while (count-- > 0) {
            pointer = pointer!!.next
        }

        return pointer!!.data
    }

    // O(1)
    fun removeFirst() {
        head = head?.next
    }

    // O(n)
    fun removeLast() {
        if (size == 1) {
            removeFirst()
            return
        }

        var pointer = head
        while (pointer?.next?.next != null) {
            pointer = pointer.next
        }
        pointer?.next = null
    }

    // O(n)
    fun remove(index: Int) {
        val size = size

        if (index == 0) {
            removeFirst()
            return
        }

        if (index == (size - 1)) {
            removeLast()
            return
        }

        if ((index < 0) || (size <= index)) {
            throw IllegalArgumentException("invalid, index out of bounds")
        }

        var pointer = head
        var count = index

        while (count-- > 1) {
            pointer = pointer!!.next
        }

        pointer?.next = pointer?.next?.next
    }

    // O(1)
    fun clear() {
        head = null
    }

    // O(n)
    val size: Int
        get() {
            var pointer = head
            var count = 0

            while (pointer != null) {
                pointer = pointer.next
                count++
            }

            return count
        }

    // O(n)
    override fun toString(): String {
        return StringBuilder("[").apply {
            var pointer = head

            while (pointer != null) {
                append("${pointer.data}")
                if (pointer.next != null) {
                    append(", ")
                }
                pointer = pointer.next
            }

            append("]")
        }.toString()
    }

}