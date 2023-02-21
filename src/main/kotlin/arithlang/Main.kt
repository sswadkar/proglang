package arithlang

import arithlang.lexer.Lexer
import arithlang.lexer.Token
import java.io.File

fun main() {
    val bufferedReader = File("src/main/kotlin/arithlang/test.jit").bufferedReader()
    val text = bufferedReader.use { it.readText() }
    Token.parsedText = text
    val tokens = Lexer(text).tokenize()
    val parser = Parser(tokens)
    println(parser.parse())
}