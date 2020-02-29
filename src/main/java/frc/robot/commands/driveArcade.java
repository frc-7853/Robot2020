/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;

public class driveArcade extends CommandBase {
  /**
   * Creates a new driveArcade.
   */
  private Drivetrain m_drivetrain;
  private DoubleSupplier m_move;
  private DoubleSupplier m_turn;


  public driveArcade(DoubleSupplier move, DoubleSupplier turn, Drivetrain drive) {
    m_drivetrain = drive;
    m_move = move;
    m_turn = turn;
    addRequirements(m_drivetrain);
}

// Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("The robot has initialized. Game on");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrain.arcadeDrive(-m_move.getAsDouble() * Constants.maxDriveSpeed, m_turn.getAsDouble() * Constants.maxDriveSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
