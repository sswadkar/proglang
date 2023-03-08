package lox

import lox.Lox.Companion.runFile
import lox.Lox.Companion.runPrompt
import java.io.IOException

fun main(args: Array<String>){
    if (args.size > 1){
        println("Usage: jlox [script]")
        throw IOException()
    } else if (args.size == 1){
        runFile(args[0])
    } else {
        runPrompt()
    }
}