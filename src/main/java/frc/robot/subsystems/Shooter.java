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

public class Shooter extends SubsystemBase {
  /**
   * Creates a new Intake.
   */
  Victor intakeMotor;
  Victor leftShooterMotor;
  Victor rightShooterMotor;
  double speed;

  public Shooter() {
    intakeMotor = new Victor(Constants.INTAKE_WHEEL_MOTOR_PORT);
    leftShooterMotor = new Victor(Constants.LEFT_SHOOTER_MOTOR);
    rightShooterMotor = new Victor(Constants.RIGHT_SHOOTER_MOTOR);
  }

  // Foward is true, backwards is false
  public void intakeMovement(int movement) {
    if (movement == 0) {
      set(intakeMotor, 0.3);
    } else if (movement == 1) {
      set(intakeMotor, -0.3);
    } else {
      set(intakeMotor, 0);
    }
  }
  public void shooter(boolean start){
    if(start){
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
  public void putData(){
    SmartDashboard.putNumber("Intake Data", speed);
    
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
