package varlang.lexer

enum class TokenType(val precedence: Int = 0) {
    // symbols
    OPEN_PAREN,
    CLOSE_PAREN,

    // Literals
    INT,
    FLOAT,

    // Operators
    PLUS(1),
    MINUS(1),
    DIV(2),
    MULT(2),

    UNDEFINED;
    // possibly add helper functions
}