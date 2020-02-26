/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.colorwheelcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.colorwheelsubsystem.ColorWheelSpinner;

public class startArm extends CommandBase {
  /**
   * Creates a new startArm.
   */
  private boolean move;
  private final ColorWheelSpinner m_arm;
  public startArm(ColorWheelSpinner arm, boolean move) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_arm = arm;
    this.move = move;
    addRequirements(m_arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(move){
      m_arm.set(0.5);

    }else{
      m_arm.set(0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_arm.set(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}