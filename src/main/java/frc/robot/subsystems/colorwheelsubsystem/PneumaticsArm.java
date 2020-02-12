/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.colorwheelsubsystem;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PneumaticsArm extends SubsystemBase {
  /**
   * Creates a new pneumaticsArm.
   */
  private final DoubleSolenoid m_DoubleSolenoid;
  //private final DoubleSolenoid m_DoubleSolenoid2 = new DoubleSolenoid(Constants.PNEUMATIC_ARM_SECOND_FOWARD_CHANNEL, Constants.PNEUMATIC_ARM_SECOND_REVERSE_CHANNEL);
  public PneumaticsArm() {
    m_DoubleSolenoid = new DoubleSolenoid(Constants.PNEUMATIC_ARM_FORWARD_CHANNEL, Constants.PNEUMATIC_ARM_REVERSE_CHANNEL);
  }
  public void setOff(){
    m_DoubleSolenoid.set(Value.kOff);
  }
  public void setControl(boolean control){
    if(control){
      m_DoubleSolenoid.set(Value.kForward);
    }else{
      m_DoubleSolenoid.set(Value.kReverse);
    }
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
