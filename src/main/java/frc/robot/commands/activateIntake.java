/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class activateIntake extends CommandBase {
  /**
   * Creates a new activateIntake.
   */
  private final Shooter m_shooter;
  private int direction;
  private double time;
  public activateIntake(Shooter shooter, int movement) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_shooter = shooter;
    direction = movement;
    addRequirements(m_shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    time = Timer.getFPGATimestamp();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    time-= Timer.getFPGATimestamp();
    if(time < 2)
    m_shooter.intakeMovement(direction);
    else{
      isFinished();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_shooter.intakeMovement(2);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(time >= 2){
      return true;
    }else{
      return false;
    }
  }
}
