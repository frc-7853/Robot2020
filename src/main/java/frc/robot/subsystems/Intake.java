/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  /**
   * Creates a new Intake.
   */
  private Victor intakeMotor;
  private double speed;
  public Intake() {
    intakeMotor = new Victor(Constants.INTAKE_WHEEL_MOTOR_PORT);
  }

  // Foward is true, backwards is false
  public void intakeMovement(int movement) {
    if (movement == 0) {
      set(intakeMotor, 0.3);
    } else if (movement == 1) {
      set(intakeMotor, -0.3);
    } else {
      set(intakeMotor, 0);
    }
  }
  public void set(Victor motor, double speed){
    motor.set(speed);
    speed = this.speed;
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
