package com.github.roosale.ctcipractice.vii

// singly linked list with head pointer
class LinkedList<T : Any> {

    private var head: Node<T>? = null

    private class Node<T : Any>(
            var data: T,
            var next: Node<T>? = null
    )

    // O(1)
    fun prepend(data: T) {
        val node = Node(data)
        node.next = head
        head = node
    }

    // O(n)
    fun append(data: T) {
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
            prepend(data)
            return
        }

        if (index == size) {
            append(data)
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

/** linked list **/
// can contain any type of data
// elements can be unsorted or sorted
// elements can be unique or duplicated
// head pointer?
// tail pointer?
// singly vs doubly linked list (allows for backtracking)
// circular linked list (tail node points to head node) can be singly or doubly

/** linked list vs array **/
// linked list
//      - slow to get kth element O(n)
//      - prepend fast O(1)
//      - append depends, O(1) with tail pointer / O(n) without tail pointer
// array
//      - fast to get kth element O(1)
//      - adds / deletes require reallocation
