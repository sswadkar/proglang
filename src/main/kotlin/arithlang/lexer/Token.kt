package arithlang.lexer

class Token(val tokenType: TokenType, private val indexRange: IntRange) {

    fun text(toParse: String): String{
        return toParse.substring(indexRange)
    }

    override fun toString(): String {
        return "Token(tokenType=${tokenType}, indexRange=${indexRange}"
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Token){
            return false
        }
        return tokenType == other.tokenType && indexRange == other.indexRange
    }
}