/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;

public class driveArcade extends CommandBase {
  /**
   * Creates a new driveArcade.
   */
  private final Drivetrain m_drivetrain;
  public driveArcade(Drivetrain drive) {
  // Use addRequirements() here to declare subsystem dependencies.
    m_drivetrain = drive;
    addRequirements(m_drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double move = Constants.maxDriveSpeed * RobotContainer.driveController.getRawAxis(Constants.DRIVER_MOVE);
    double turn = Constants.maxDriveSpeed * RobotContainer.driveController.getRawAxis(Constants.DRIVER_TURN);
    m_drivetrain.arcadeDrive(move, turn);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
