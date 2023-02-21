package arithlang.lexer

import java.util.*

class Lexer(private var stringToBeTokenized: String = "") {
    var tokens = mutableListOf<Token>()

    private var textIterator: ListIterator<Char> = stringToBeTokenized.toList().listIterator()

    fun add(stringToBeTokenized: String){
        this.stringToBeTokenized += stringToBeTokenized
        textIterator = this.stringToBeTokenized.toList().listIterator()
    }

    private fun lookAhead(): Char?{
        return stringToBeTokenized.getOrNull(textIterator.nextIndex())
    }

    private fun isValidChar(char: Char): Boolean{
        return char in digits || char in operators || char in symbols
    }

    private fun lex(char: Char, index: Int): Token{
        return when(char){
            // Operators
            '+' -> Token(TokenType.PLUS, index..index)
            '-' -> Token(TokenType.MINUS, index..index)
            '*' -> Token(TokenType.MULT, index..index)
            '/' -> Token(TokenType.DIV, index..index)

            // Numbers
            in digits -> {
                // this one more complicated bc you can have multiple digits
                var endIndex = index
                while (lookAhead()?.isDigit() == true){
                    endIndex += 1
                }
                Token(TokenType.INT, index..endIndex)
            }

            // Symbols
            '(' -> Token(TokenType.OPEN_PAREN, index..index)
            ')' -> Token(TokenType.CLOSE_PAREN, index..index)
            else -> Token(TokenType.UNDEFINED, index..index)
        }
    }


    fun tokenize(): MutableList<Token>{
        while (textIterator.hasNext()){
            val index = textIterator.nextIndex()
            val char = textIterator.next()

            if (isValidChar(char)){
                tokens.add(lex(char, index))
            }
        }

        return tokens
    }

    companion object{
        val operators = "+-*/"
        val symbols = "()"
        val digits = "0123456789"
    }

}