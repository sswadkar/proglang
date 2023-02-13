package utils

class Motor(
    var name: String,
    var motorConfiguration: MotorConfiguration = MotorConfiguration(
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0
    )
) {

    // All of these would be updated in a real example but they just aren't here
    val isConnected = false
    val appliedVoltage: Double = 0.0
    val statorCurrent: Double = 0.0
    val supplyCurrent: Double = 0.0

    fun setMotorVoltage(appliedVoltage: Double){
        // it's fake so this doesn't work
    }

    fun setPower(power: Double){
        // it's fake so this doesn't work
    }
}