/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.colorwheelcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.commands.colorwheelcommands.colorWheelSetSpeed;
import frc.robot.subsystems.colorwheelsubsystem.ColorWheelSpinner;

public class colorWheelSetSpeed extends CommandBase { 
  /**
   * Creates a new colorWheelSetSpeed.
   */
  private ColorWheelSpinner m_ColorWheelSpinner;

  public colorWheelSetSpeed(ColorWheelSpinner colorwheelspinner) {
    m_ColorWheelSpinner = colorwheelspinner;
    addRequirements(m_ColorWheelSpinner);
}

// Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_ColorWheelSpinner.set(Constants.colorWheelSpeed);
    m_ColorWheelSpinner.putData();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_ColorWheelSpinner.set(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
