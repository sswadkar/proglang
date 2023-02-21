package arithlang

import arithlang.lexer.Token
import arithlang.lexer.TokenType

class Parser(private val tokens: MutableList<Token>) {
    private val tokenIterator = tokens.listIterator()

    private var currentSymbol: TokenType = TokenType.UNDEFINED

    fun parse(): List<Node> {
        val nodes = mutableListOf<Node>()

        while (tokenIterator.hasNext()) {
            val nextSymbol = tokenIterator.next()

            if (isOperator(nextSymbol.tokenType)){
                currentSymbol = nextSymbol.tokenType
                nodes.add(extractExpression())
            }
        }

        return nodes
    }

    private fun lookAhead(): Token?{
        return tokens[tokenIterator.nextIndex()]
    }

    private fun extractExpression(): Node {
        var lhs : Node = Node.UnaryNode(TokenType.INT, tokenIterator.next())
        val nextToken = lookAhead()

        while (nextToken?.tokenType == TokenType.INT){
            val recursiveNodeConstruction = extractExpression()

            lhs = Node.CompoundExp(currentSymbol, lhs, recursiveNodeConstruction)
        }

        return lhs
    }

    private fun isOperator(symbol: TokenType): Boolean{
        return symbol == TokenType.PLUS || symbol == TokenType.MINUS || symbol == TokenType.MULT || symbol == TokenType.DIV
    }
}