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
   * Creates a new Shooter.
   */
  Victor rightShooterVictor;
  Victor leftShooterVictor;
  private double currentShooterSpeed = 0;

  public Shooter() {
    rightShooterVictor = new Victor(Constants.RIGHT_SHOOTER_MOTOR);
    leftShooterVictor = new Victor(Constants.LEFT_SHOOTER_MOTOR);
  }

  public void shoot(boolean increaseSpeed){
    if (increaseSpeed == true){
      /*if(currentShooterSpeed != Constants.increasedShooterSpeed){
        currentShooterSpeed += 0.05;
      } */ 
      currentShooterSpeed = Constants.increasedShooterSpeed;    
    }else{
      /* if(currentShooterSpeed != Constants.increasedShooterSpeed){
        currentShooterSpeed -= 0.05;
      }*/
      currentShooterSpeed = Constants.defaultShooterSpeed;
    }
    set(currentShooterSpeed);
  }
  public void end()
  {
    set(0);
  }
  public void set(double speed){
  /*rightShooterVictor.setVoltage(-speed);
    leftShooterVictor.setVoltage(speed);
    */
    rightShooterVictor.set(-speed);
    leftShooterVictor.set(speed);
  }
  public void putData(){
    SmartDashboard.putNumber("Moving Speed", currentShooterSpeed);
    SmartDashboard.putNumber("Current Shooter Speed", currentShooterSpeed);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
