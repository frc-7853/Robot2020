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
   * Creates a new Shooter.
   */
  Victor rightShooterVictor;
  Victor leftShooterVictor;

  public Shooter() {
    rightShooterVictor = new Victor(Constants.RIGHT_SHOOTER_MOTOR);
    leftShooterVictor = new Victor(Constants.LEFT_SHOOTER_MOTOR);
  }

  public void shoot(double speed){
    rightShooterVictor.set(speed);
    leftShooterVictor.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
