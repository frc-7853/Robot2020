/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.colorwheelcommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.colorwheelsubsystem.ColorWheelSpinner;

public class armStartup extends CommandBase {
  /**
   * Creates a new pneumaticsArm.
   */
  private final ColorWheelSpinner m_spinnerwheel;
  private double time;
  public armStartup(ColorWheelSpinner spinnerArm) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_spinnerwheel = spinnerArm;
    addRequirements(m_spinnerwheel);
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
    if(time < 2){
      m_spinnerwheel.setControl(true);

    }
    m_spinnerwheel.setOff();
    m_spinnerwheel.set(Constants.colorWheelSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_spinnerwheel.set(0);
    m_spinnerwheel.setControl(false);
    m_spinnerwheel.setOff();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
