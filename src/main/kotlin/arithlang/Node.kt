package arithlang

import arithlang.lexer.Token
import arithlang.lexer.TokenType

sealed class Node {
    // using varargs allows us to create compounded arithmetic expressions
    class CompoundExp(val symbol: TokenType, vararg nodes: Node): Node() {}
    class UnaryNode(val type: TokenType, val value: Token): Node() {}
}