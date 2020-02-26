/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.colorwheelcommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.colorwheelsubsystem.PneumaticsArm;

public class raiseArm extends CommandBase {
  /**
   * Creates a new raiseArm.
   */
  private final PneumaticsArm m_arm;
  private final boolean raiseArm;
  public raiseArm(PneumaticsArm arm, boolean raiseArm) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_arm = arm;
    this.raiseArm = raiseArm;
    addRequirements(m_arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_arm.raiseArm(raiseArm);
  }
}
