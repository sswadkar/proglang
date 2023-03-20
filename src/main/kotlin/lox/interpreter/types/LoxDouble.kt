package lox.interpreter.types

import kotlin.math.pow

class LoxDouble(override val value: Double) : LoxNumber {
    constructor(value: String) : this(value.toDouble())

    override operator fun plus(other: LoxNumber): LoxDouble {
        return when (val otherValue = other.value) {
            is Int -> LoxDouble(value + otherValue)
            is Double -> LoxDouble(value + otherValue)
            else -> throw Error()
        }
    }

    override operator fun minus(other: LoxNumber): LoxDouble {
        return when (val otherValue = other.value) {
            is Int -> LoxDouble(value - otherValue)
            is Double -> LoxDouble(value - otherValue)
            else -> throw Error()
        }
    }

    override operator fun times(other: LoxNumber): LoxDouble {
        return when (val otherValue = other.value) {
            is Int -> LoxDouble(value * otherValue)
            is Double -> LoxDouble(value * otherValue)
            else -> throw Error()
        }
    }

    override operator fun div(other: LoxNumber): LoxDouble {
        return when (val otherValue = other.value) {
            is Int -> LoxDouble(value / otherValue)
            is Double -> LoxDouble(value / otherValue)
            else -> throw Error()
        }
    }

    override fun pow(other: LoxNumber): LoxDouble {
        return when (val otherValue = other.value) {
            is Int -> LoxDouble(value.pow(otherValue))
            is Double -> LoxDouble(value.pow(otherValue))
            else -> throw Error()
        }
    }

    override fun toString(): String {
        return value.toString()
    }
}