package arithlang

sealed class Node {
    data class TokenNode(val name: String, val children: MutableList<Node>): Node() {}
    data class ValueNode(val name: String, val children: MutableList<Node>): Node() {}
}