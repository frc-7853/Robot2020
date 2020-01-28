/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//import edu.wpi.first.wpilibj.XboxController;

import frc.robot.commands.*;
import frc.robot.commands.colorwheelcommands.*;
import frc.robot.subsystems.*;
import frc.robot.subsystems.colorwheelsubsystem.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {


// The robot's subsystems and commands are defined here...

  private final Drivetrain drivetrain = new Drivetrain();
  private final Shooter shooter = new Shooter();
  private final ColorSensor colorsensor = new ColorSensor();
  //private XboxController driveController;
  private Joystick driveController;
  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    //driveController = new XboxController(Constants.DRIVER_CONTROLLER_PORT);
    driveController = new Joystick(Constants.DRIVER_CONTROLLER_PORT);
    drivetrain.setDefaultCommand(new driveArcade(() -> driveController.getRawAxis(Constants.DRIVER_MOVE),
      () -> driveController.getRawAxis(Constants.DRIVER_TURN), drivetrain));
    shooter.setDefaultCommand(new shooterSetSpeed(shooter, false));
    drivetrain.putData(driveController.getRawAxis(Constants.DRIVER_MOVE),
      driveController.getRawAxis(Constants.DRIVER_TURN),Constants.maxDriveSpeed);
    colorsensor.setDefaultCommand(new colorSensing(colorsensor));
    // Puts all required data into the SmartDashboard
    
    shooter.putData();
    colorsensor.putData();
    configureButtonBindings();
    
  }


  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    final JoystickButton aButton = new JoystickButton(driveController, Constants.A_BUTTON);
    aButton.whileHeld(new shooterSetSpeed(shooter,true));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    // return m_autoCommand;
    return null;
  }
}
