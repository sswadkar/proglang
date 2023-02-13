import utils.SubsystemBase
import utils.doubleClamp

class Subsystem(val io: SubsystemIO): SubsystemBase() {
    val inputs = SubsystemIO.SubsystemInputs()

    override fun periodic() {
        io.updateInputs(inputs)
    }

    fun setVoltage(voltage: Double){
        // clamping voltage
        val appliedVoltage = doubleClamp(voltage, -12.0, 12.0)
        io.setMotorVoltage(appliedVoltage)
    }
}