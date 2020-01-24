/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Shooter;

public class shooterSetSpeed extends CommandBase {
  private Shooter m_shooter;
  private double currentShooterSpeed = 0;
  /**
   * Creates a new shooterSetSpeed.
   */
  public shooterSetSpeed(Shooter shoot, boolean increaseSpeed) {
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
    m_shooter = shoot;
    addRequirements(m_shooter);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_shooter.shoot(currentShooterSpeed);
    SmartDashboard.putNumber("Current Shooter Speed", currentShooterSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    if (isFinished()){
      m_shooter.shoot(0);
    }else{
      m_shooter.shoot(currentShooterSpeed);
    }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
