/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  /**
   * Creates a new Drivetrain.
   */
  Victor leftFrontVictor;
  Victor leftBackVictor;
  Victor rightFrontVictor;
  Victor rightBackVictor;
  DifferentialDrive drive;

  public Drivetrain() {
    leftFrontVictor = new Victor(Constants.LEFT_FRONT_VICTORPORT);
    leftBackVictor = new Victor(Constants.LEFT_BACK_VICTORPORT);
    rightFrontVictor = new Victor(Constants.RIGHT_FRONT_VICTORPORT);
    rightBackVictor = new Victor(Constants.RIGHT_BACK_VICTORPORT);
    SpeedControllerGroup leftVictors = new SpeedControllerGroup(leftFrontVictor, leftBackVictor);
    SpeedControllerGroup rightVictors = new SpeedControllerGroup(rightFrontVictor, rightBackVictor);
    drive = new DifferentialDrive(leftVictors, rightVictors);
  }
  public void arcadeDrive(double moveSpeed, double turnSpeed){
    drive.arcadeDrive(moveSpeed, turnSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
