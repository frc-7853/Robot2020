/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class activateIntake extends CommandBase {
  /**
   * Creates a new activateIntake.
   */
  private final Intake m_intake;
  private int direction;
  private double time;
  public activateIntake(Intake intake, int movement) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_intake = intake;
    direction = movement;
    addRequirements();
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
    m_intake.intakeMovement(direction);
    else{
      isFinished();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_intake.intakeMovement(2);
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
