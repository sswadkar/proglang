package utils

data class MotorConfiguration(val statorCurrentLimit: Double, val supplyCurrentLimit: Double, val kP_0: Double, val kI_0: Double, val kD_0: Double, val openLoopRampRate: Double)
