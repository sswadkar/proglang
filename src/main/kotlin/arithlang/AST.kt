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

        abstract class NumExp(val v: Double): Exp() {
            override fun <T> accept(visitor: Visitor<T>): T {
                return visitor.visit(this)
            }
        }

        abstract class CompoundArithExp(vararg args: Exp): Exp() {}

        abstract class AddExp(vararg args: Exp): CompoundArithExp(){
            override fun <T> accept(visitor: Visitor<T>): T {
                return visitor.visit(this)
            }
        }

        abstract class SubExp(vararg args: Exp): CompoundArithExp(){
            override fun <T> accept(visitor: Visitor<T>): T {
                return visitor.visit(this)
            }
        }

        abstract class MultExp(vararg args: Exp): CompoundArithExp(){
            override fun <T> accept(visitor: Visitor<T>): T {
                return visitor.visit(this)
            }
        }

        abstract class DivExp(vararg args: Exp): CompoundArithExp(){
            override fun <T> accept(visitor: Visitor<T>): T {
                return visitor.visit(this)
            }
        }

        interface Visitor<T> {
            fun visit(p: Program): T
            fun visit(e: NumExp): T
            fun visit(e: AddExp): T
            fun visit(e: SubExp): T
            fun visit(e: MultExp): T
            fun visit(e: DivExp): T
        }
    }
}