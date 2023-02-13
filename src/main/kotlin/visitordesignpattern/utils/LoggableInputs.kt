package utils

interface LoggableInputs {

    fun toLog(tableKey: String){}

    fun fromLog(tableKey: String) {}
}