/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.colorwheelsubsystem;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ColorWheelSpinner extends SubsystemBase {
  /**
   * Creates a new ColorWheelSpinner.
   */
  private final Victor colorWheel;

  
  public ColorWheelSpinner() {
    colorWheel = new Victor(Constants.COLOR_WHEEL_MOTOR_PORT);
  }
  public void set(double speed){
    colorWheel.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
