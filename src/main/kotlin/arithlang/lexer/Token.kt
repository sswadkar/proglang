package arithlang.lexer

class Token(val tokenType: TokenType, private val indexRange: IntRange) {

    override fun toString(): String {
        return "Token(tokenType=${tokenType}, indexRange=${indexRange}, text='${parsedText.substring(indexRange)}'"
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Token){
            return false
        }
        return tokenType == other.tokenType && indexRange == other.indexRange
    }

    companion object{
        var parsedText = ""
    }
}