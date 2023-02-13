import utils.LoggableInputs
import utils.MotorConfiguration

interface SubsystemIO {
    class SubsystemInputs: LoggableInputs {

        var motorName = ""
        var motorConnected = false
        var motorAppliedVoltage = 0.0
        var motorStatorCurrent = 0.0
        var motorSupplyCurrent = 0.0

        var sensorName = ""
        var sensorConnected = false

        override fun toLog(tableKey: String) {
            // TODO implement toLog functionality
        }

        override fun fromLog(tableKey: String) {
            // TODO implement fromLog functionality
        }
    }

    fun updateInputs(inputs: SubsystemInputs) {}

    fun setMotorVoltage(voltage: Double) {}

    fun setMotorName(name: String) {}

    fun configureMotorFactory(configuration: MotorConfiguration) {}

    fun setSensorName(name: String) {}

    fun zeroAngle(toAngle: Double = 0.0) {}
}