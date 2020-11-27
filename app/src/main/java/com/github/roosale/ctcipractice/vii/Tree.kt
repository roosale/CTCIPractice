package com.github.roosale.ctcipractice.vii

// binary search tree
class Tree {

    private var root: Node? = null

    private class Node(
            var data: Int,
            var left: Node? = null,
            var right: Node? = null
    ) {

        // unbalanced O(n) / balanced O(log n)
        fun insert(value: Int) {
            if (value <= data) {
                if (left == null) {
                    left = Node(value)
                } else {
                    left?.insert(value)
                }
            } else {
                if (right == null) {
                    right = Node(value)
                } else {
                    right?.insert(value)
                }
            }
        }

        // unbalanced O(n) / balanced O(log n)
        fun contains(value: Int): Boolean {
            if (value == data) return true

            return if (value < data) {
                left?.contains(value) ?: false
            } else {
                right?.contains(value) ?: false
            }
        }

        companion object {

            // O(n)
            fun build(list: List<Int>, start: Int, end: Int): Node? {
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
            fun preOrder(list: MutableList<Int>, node: Node?) {
                node?.run {
                    list.add(this.data)
                    left?.run { preOrder(list, this) }
                    right?.run { preOrder(list, this) }
                }
            }

            // O(n)
            fun inOrder(list: MutableList<Int>, node: Node?) {
                node?.run {
                    left?.run { inOrder(list, this) }
                    list.add(this.data)
                    right?.run { inOrder(list, this) }
                }
            }

            // O(n)
            fun postOrder(list: MutableList<Int>, node: Node?) {
                node?.run {
                    left?.run { postOrder(list, this) }
                    right?.run { postOrder(list, this) }
                    list.add(this.data)
                }
            }

        }

    }

    // unbalanced O(n) / balanced O(log n)
    fun insert(value: Int) {
        if (root == null) {
            root = Node(value)
        } else {
            root?.insert(value)
        }
    }

    // unbalanced O(n) / balanced O(log n)
    fun contains(value: Int): Boolean {
        return root?.contains(value) ?: false
    }

    // O(n) + O(n)
    fun balance() {
        mutableListOf<Int>().also {
            Node.inOrder(it, root)
            root = Node.build(
                    list = it,
                    start = 0,
                    end = it.size - 1
            )
        }
    }

    // O(n)
    val preOrder: String
        get() = mutableListOf<Int>()
                .also { Node.preOrder(it, root) }
                .joinToString(
                        separator = ", ",
                        prefix = "[",
                        postfix = "]"
                )

    // O(n)
    val inOrder: String
        get() = mutableListOf<Int>()
                .also { Node.inOrder(it, root) }
                .joinToString(
                        separator = ", ",
                        prefix = "[",
                        postfix = "]"
                )

    // O(n)
    val postOrder: String
        get() = mutableListOf<Int>()
                .also { Node.postOrder(it, root) }
                .joinToString(
                        separator = ", ",
                        prefix = "[",
                        postfix = "]"
                )

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

