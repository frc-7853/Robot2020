/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  /**
   * Creates a new Intake.
   */
  Victor leftShooterMotor;
  Victor rightShooterMotor;
  double speed;

  public Shooter() {
    leftShooterMotor = new Victor(Constants.LEFT_SHOOTER_MOTOR);
    rightShooterMotor = new Victor(Constants.RIGHT_SHOOTER_MOTOR);
  }
  
  public void shooter(int start){
    if(start == 0){
      set(leftShooterMotor, 0.5);
      set(rightShooterMotor, -0.5);
    }else{
      set(leftShooterMotor, 0);
      set(rightShooterMotor, 0);
    }
  }

  public void set(Victor motor, double speed){
      motor.set(speed);
      speed = this.speed;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
