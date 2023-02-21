package arithlang

import arithlang.lexer.TokenType

sealed class Node {
    class Exp(val symbol: TokenType, vararg nodes: Node): Node() {}
}