package lox.interpreter.types

import kotlin.math.pow

class LoxInt(override val value: Int) : LoxNumber {
    constructor(value: String) : this(value.toInt())

    override operator fun plus(other: LoxNumber): LoxNumber {
        return when (val otherValue = other.value) {
            is Int -> LoxInt(value + otherValue)
            is Double -> LoxDouble(value + otherValue)
            else -> throw Error()
        }
    }

    override operator fun minus(other: LoxNumber): LoxNumber {
        return when (val otherValue = other.value) {
            is Int -> LoxInt(value - otherValue)
            is Double -> LoxDouble(value - otherValue)
            else -> throw Error()
        }
    }

    override operator fun times(other: LoxNumber): LoxNumber {
        return when (val otherValue = other.value) {
            is Int -> LoxInt(value * otherValue)
            is Double -> LoxDouble(value * otherValue)
            else -> throw Error()
        }
    }

    override operator fun div(other: LoxNumber): LoxNumber {
        return when (val otherValue = other.value) {
            is Int -> LoxInt(value / otherValue)
            is Double -> LoxDouble(value / otherValue)
            else -> throw Error()
        }
    }

    override fun pow(other: LoxNumber): LoxNumber {
        return when (val otherValue = other.value) {
            is Int -> LoxInt(
                value
                    .toDouble()
                    .pow(otherValue)
                    .toInt()
            )
            is Double -> LoxDouble(
                value
                    .toDouble()
                    .pow(otherValue)
            )
            else -> throw Error()
        }
    }

    override fun toString(): String {
        return value.toString()
    }
}