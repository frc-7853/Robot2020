/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  /**
   * Creates a new Intake.
   */
  Victor intakeMotor;
  double speed;

  public Intake() {
    intakeMotor = new Victor(Constants.INTAKE_WHEEL_MOTOR_PORT);
  }
  public void set(double speed){
      intakeMotor.set(speed);
      speed = this.speed;
  }
  public void putData(){
    SmartDashboard.putNumber("Intake Data", speed);
    
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
