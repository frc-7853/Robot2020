/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.colorwheelcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.colorwheelsubsystem.ColorSensor;

public class colorSensing extends CommandBase {
  /**
   * Creates a new colorSensing.
   */
  private ColorSensor m_colorSensor;

  public colorSensing(ColorSensor colorSensor) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_colorSensor = colorSensor;
    addRequirements(m_colorSensor);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Color is now being seen.");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_colorSensor.colorMatch();
    //m_colorSensor.putData();
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
