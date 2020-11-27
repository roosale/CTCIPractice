package com.github.roosale.ctcipractice.vii

// binary search tree
class Tree<T : Comparable<T>> {

    private class Node<T>(
            var data: T,
            var left: Node<T>? = null,
            var right: Node<T>? = null
    )

    private var root: Node<T>? = null

    // unbalanced O(n) / balanced O(log n)
    fun insert(value: T) {
        if (root == null) {
            root = Node(value)
        } else {
            insert(root, value)
        }
    }

    private fun insert(node: Node<T>?, value: T) {
        if (node == null) return

        if (value <= node.data) {
            if (node.left == null) {
                node.left = Node(value)
            } else {
                insert(node.left, value)
            }
        } else {
            if (node.right == null) {
                node.right = Node(value)
            } else {
                insert(node.right, value)
            }
        }
    }

    // unbalanced O(n) / balanced O(log n)
    fun contains(value: T): Boolean {
        return contains(root, value)
    }

    private fun contains(node: Node<T>?, value: T): Boolean {
        if (node == null) return false
        if (value == node.data) return true

        return if (value < node.data) {
            contains(node.left, value)
        } else {
            contains(node.right, value)
        }
    }

    // O(n)
    fun balance() {
        mutableListOf<T>().also {
            inOrder(it, root)
            root = build(
                    list = it,
                    start = 0,
                    end = it.size - 1
            )
        }
    }

    private fun build(list: List<T>, start: Int, end: Int): Node<T>? {
        // out of bounds
        if (start > end) return null
        // no children
        if (start == end) return Node(list[start])
        // has children
        val middle = ((start + end) / 2)
        return Node(list[middle]).apply {
            left = build(
                    list = list,
                    start = start,
                    end = (middle - 1)
            )
            right = build(
                    list = list,
                    start = (middle + 1),
                    end = end
            )
        }
    }

    // O(n)
    val preOrder: String
        get() {
            return mutableListOf<T>()
                    .also { preOrder(it, root) }
                    .joinToString(
                            separator = ", ",
                            prefix = "[",
                            postfix = "]"
                    )
        }

    private fun preOrder(list: MutableList<T>, node: Node<T>?) {
        node?.run {
            list.add(this.data)
            left?.run { preOrder(list, this) }
            right?.run { preOrder(list, this) }
        }
    }

    // O(n)
    val inOrder: String
        get() {
            return mutableListOf<T>()
                    .also { inOrder(it, root) }
                    .joinToString(
                            separator = ", ",
                            prefix = "[",
                            postfix = "]"
                    )
        }

    private fun inOrder(list: MutableList<T>, node: Node<T>?) {
        node?.run {
            left?.run { inOrder(list, this) }
            list.add(this.data)
            right?.run { inOrder(list, this) }
        }
    }

    // O(n)
    val postOrder: String
        get() {
            return mutableListOf<T>()
                    .also { postOrder(it, root) }
                    .joinToString(
                            separator = ", ",
                            prefix = "[",
                            postfix = "]"
                    )
        }

    private fun postOrder(list: MutableList<T>, node: Node<T>?) {
        node?.run {
            left?.run { postOrder(list, this) }
            right?.run { postOrder(list, this) }
            list.add(this.data)
        }
    }

}

/** tree **/
// 0 to n child nodes

/** binary tree **/
// 0 to 2 child nodes

/** types of binary trees; complete, full, perfect **/
// complete; every level is fully filled, except the last level can be filled from left to right
// full; every node has 0 or 2 children, aka no node has only one child
// perfect; the tree is both full and complete, therefore ((2^k) - 1) nodes

/** binary search tree **/
// specific ordering property, for any node
//      - left subtree nodes are less than the root node
//      - right subtree nodes are greater than the root node

/** balanced vs unbalanced **/
// balanced; roughly same number of nodes on left and right
// (abs(leftHeight - rightHeight) <= 1) at every node (so height = log n)
// therefore
//      - insert O(log n)
//      - find O(log n)
// unbalanced; no guarantee of tree height, therefore
//      - insert O(n)
//      - find O(n)
// can self-balance with red black trees or AVL trees
// can balance an unbalanced BST by
//      1. in-order traversal of unbalanced BST to generate sorted array
//      2. creating a new BST from sorted array

/** traversing; pre-order, in-order, post-order **/
//          B
//         / \
//        A   C
// pre-order; root -> left -> right (B, A, C)
// in-order; left -> root -> right (A, B, C)
// post-order; left -> right -> root (A, C, B)

