package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.helpers.appendix;
import frc.robot.helpers.common;

public class IntakeSubsystem {

    Joystick gamePad = new Joystick(appendix.driveControllerID);
    
    WPI_VictorSPX intakeMotor = new WPI_VictorSPX(appendix.motorIntake);

    boolean getArmTrigger() {
        double rightValue = gamePad.getRawAxis(appendix.triggerRight);
        double leftValue =  gamePad.getRawAxis(appendix.triggerLeft);
        return (rightValue != leftValue);
    }

    public void teleopPeriodic() {
        // intakeMotor.set(common.speedLimit(common.quadraticSpeed(getArmTrigger()), appendix.maxIntakeSpeed));
        intakeMotor.set(-gamePad.getRawAxis(appendix.axisRightY));
        if (getArmTrigger())
            intakeMotor.set(-0.1);
    }
}
