package utils

class ServoSensor(var name: String) {
    val isConnected: Boolean = false
    val servoAngle: Double = 0.0

    fun zeroAngle(toAngle: Double){}
}