import utils.LoggableInputs
import utils.Motor
import utils.MotorConfiguration
import utils.ServoSensor

class SubsystemIOReal: SubsystemIO {

    val motor = Motor("motor")
    val servoSensor = ServoSensor("servo")

    override fun setMotorVoltage(voltage: Double) {
        motor.setMotorVoltage(voltage)
    }

    override fun updateInputs(inputs: SubsystemIO.SubsystemInputs) {
        inputs.motorConnected = motor.isConnected
        inputs.motorName = motor.name
        inputs.motorAppliedVoltage = motor.appliedVoltage
        inputs.motorStatorCurrent = motor.statorCurrent
        inputs.motorSupplyCurrent = motor.supplyCurrent

    }

    override fun configureMotorFactory(configuration: MotorConfiguration) {
        motor.motorConfiguration = configuration
    }

    override fun setMotorName(name: String) {
        motor.name = name
    }

    override fun setSensorName(name: String) {
        servoSensor.name = name
    }

    override fun zeroAngle(toAngle: Double){
        servoSensor.zeroAngle(toAngle)
    }
}