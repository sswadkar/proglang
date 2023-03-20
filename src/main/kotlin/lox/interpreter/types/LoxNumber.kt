package lox.interpreter.types

interface LoxNumber: LoxType<Number> {
    override val value: Number

    operator fun plus(other: LoxNumber): LoxNumber

    operator fun minus(other: LoxNumber): LoxNumber

    operator fun times(other: LoxNumber): LoxNumber

    operator fun div(other: LoxNumber): LoxNumber

    fun pow(other: LoxNumber): LoxNumber

    override fun toString() : String
}