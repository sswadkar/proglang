package lox.interpreter

import lox.interpreter.types.LoxDouble
import lox.interpreter.types.LoxInt
import lox.interpreter.types.LoxNumber
import lox.lexer.TokenType
import lox.parser.Node

class Interpreter(private val sourceText: String) {
    fun <T> walk(node: Node): T {
        return when (node) {
            is Node.ArithmeticNode -> parseArithmeticNode(node)
            is Node.NumberNode -> parseNumberNode(node)
            else -> throw Error()
        }
    }

    private inline fun <reified T : LoxNumber> parseArithmeticNode(node: Node.ArithmeticNode): T {
        val leftNode = walk<LoxNumber>(node.leftNode)
        val rightNode = walk<LoxNumber>(node.rightNode)

        return when (node.operator) {
            TokenType.PLUS -> leftNode + rightNode
            TokenType.MINUS -> leftNode - rightNode
            TokenType.ASTERISK -> leftNode * rightNode
            TokenType.FORWARD_SLASH -> leftNode / rightNode
            TokenType.DOUBLE_ASTERISK -> leftNode.pow(rightNode)
            else -> throw Error()
        } as T
    }

    private inline fun <reified T : LoxNumber> parseNumberNode(node: Node.NumberNode): T {
        return when (node.underlyingToken.kind) {
            TokenType.INT -> LoxInt(node.underlyingToken.text(sourceText))
            TokenType.FLOAT -> LoxDouble(node.underlyingToken.text(sourceText))
            else -> throw Error()
        } as T
    }
}
