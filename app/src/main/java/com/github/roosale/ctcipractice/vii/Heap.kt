package com.github.roosale.ctcipractice.vii

// max heap
class Heap {

    private var capacity = 10
    private var size = 0

    private var items = IntArray(capacity)

    private fun getLeftChildIndex(parentIndex: Int) = 2 * parentIndex + 1
    private fun getRightChildIndex(parentIndex: Int) = 2 * parentIndex + 2
    private fun getParentIndex(childIndex: Int) = (childIndex - 1) / 2

    private fun hasLeftChild(index: Int) = getLeftChildIndex(index) < size
    private fun hasRightChild(index: Int) = getRightChildIndex(index) < size
    private fun hasParent(index: Int) = getParentIndex(index) >= 0

    private fun leftChild(index: Int) = items[getLeftChildIndex(index)]
    private fun rightChild(index: Int) = items[getRightChildIndex(index)]
    private fun parent(index: Int) = items[getParentIndex(index)]

    private fun swap(indexOne: Int, indexTwo: Int) {
        val temp = items[indexOne]
        items[indexOne] = items[indexTwo]
        items[indexTwo] = temp
    }

    private fun ensureExtraCapacity() {
        if (size == capacity) {
            items = items.copyOf(capacity * 2)
            capacity *= 2
        }
    }

    fun peek(): Int {
        if (size == 0) throw Exception("empty heap")
        return items[0]
    }

    fun poll(): Int {
        if (size == 0) throw Exception("empty heap")

        val item = items[0]
        items[0] = items[size - 1]
        size--
        heapifyDown()
        return item
    }

    private fun heapifyDown() {
        var index = 0

        while (hasLeftChild(index)) {
            var largerChildIndex = getLeftChildIndex(index)
            if (hasRightChild(index) && rightChild(index) >= leftChild(index)) {
                largerChildIndex = getRightChildIndex(index)
            }

            if (items[index] >= items[largerChildIndex]) {
                break
            } else {
                swap(index, largerChildIndex)
            }
            index = largerChildIndex
        }
    }

    fun add(item: Int) {
        ensureExtraCapacity()

        items[size] = item
        size++
        heapifyUp()
    }

    private fun heapifyUp() {
        var index = size - 1
        while (hasParent(index) && parent(index) <= items[index]) {
            swap(getParentIndex(index), index)
            index = getParentIndex(index)
        }
    }

}

/** max/min heap invariants **/
// max; a parent node is larger than its children
// max; a parent node is smaller than its children