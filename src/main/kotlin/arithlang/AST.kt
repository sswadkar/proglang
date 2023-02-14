package arithlang

interface AST {
    companion object{
        abstract class ASTNode{
            abstract fun <T> accept(visitor: Visitor<T>): T
        }

        abstract class Program(val _e: Exp): ASTNode() {
            override fun <T> accept(visitor: Visitor<T>): T {
                return visitor.visit(this)
            }
        }

        abstract class Exp: ASTNode(){}

//        abstract class NumExp(val v: Double): Exp() {
//            override fun <T> accept(visitor: Visitor<T>): T {
//                return visitor.visit(this)
//            }
//        }

        interface Visitor<T> {
            fun visit(p: Program): T
//            fun visit(): T
//            fun visit(): T
//            fun visit(): T
//            fun visit(): T

        }
    }
}