package lox

import java.io.BufferedReader
import java.io.InputStreamReader
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Paths
import java.util.Scanner

class Lox {
    companion object{
        fun runFile(path: String){
            val bytes = Files.readAllBytes(Paths.get(path))
            run(String(bytes, Charset.defaultCharset()))
        }

        fun runPrompt(){
            val input = InputStreamReader(System.`in`)
            val reader = BufferedReader(input)

            while (true){
                println("> ")
                val line = reader.readLine() ?: break
                run(line)
            }
        }

        fun run(source: String){
            val scanner = Scanner(source)
            for (token in scanner.tokens()){
                println(token)
            }
        }
    }
}