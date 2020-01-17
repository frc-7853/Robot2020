/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;

public class driveArcade extends CommandBase {
  /**
   * Creates a new driveArcade.
   */
  private Drivetrain m_drivetrain;
  private Joystick m_stick;
  public driveArcade(Drivetrain drive, Joystick stick) {
  // Use addRequirements() here to declare subsystem dependencies.
    m_stick = stick;
    m_drivetrain = drive;
    addRequirements(m_drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Its on lmao");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double move = Constants.maxDriveSpeed * m_stick.getRawAxis(Constants.DRIVER_MOVE);
    double turn = Constants.maxDriveSpeed * m_stick.getRawAxis(Constants.DRIVER_TURN);
    m_drivetrain.arcadeDrive(move, turn);
    SmartDashboard.putNumber("Move Speed", move);
    SmartDashboard.putNumber("Turn Speed", turn);
    SmartDashboard.putNumber("Max Speed", Constants.maxDriveSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(final boolean interrupted) {
    m_drivetrain.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
