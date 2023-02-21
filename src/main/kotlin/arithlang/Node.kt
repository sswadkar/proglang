package arithlang

import arithlang.lexer.Token
import arithlang.lexer.TokenType

sealed class Node {
    class CompoundExp(val symbol: TokenType, val lhs: Node, val rhs: Node): Node() {
        override fun toString(): String {
            return "CompoundExp(symbol:${symbol}, left hand side:${lhs}, right hand side:${rhs})"
        }
    }
    class UnaryNode(val type: TokenType, val value: Token): Node() {
        override fun toString(): String {
            return "UnaryNode(type:${type}, value:${value})"
        }
    }
}