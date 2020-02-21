/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.commands.*;
import frc.robot.commands.colorwheelcommands.*;
import frc.robot.subsystems.*;
import frc.robot.subsystems.colorwheelsubsystem.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
  private final ColorWheelSpinner colorwheelspinner = new ColorWheelSpinner();
  private final Intake intake = new Intake();
  //controllers
  private Joystick driveController;
  private Joystick operateController;
  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    //driveController = new XboxController(Constants.DRIVER_CONTROLLER_PORT);
    driveController = new Joystick(Constants.DRIVER_CONTROLLER_PORT);
    drivetrain.setDefaultCommand(new driveArcade(() -> driveController.getRawAxis(Constants.DRIVER_MOVE),
      () -> driveController.getRawAxis(Constants.DRIVER_TURN), drivetrain));
    operateController = new Joystick(Constants.OPERATOR_CONTROLLER_PORT);
    colorsensor.setDefaultCommand(new colorSensing(colorsensor));
    configureButtonBindings();
    
  }


  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //driver buttons

    
    //operator buttons    
    final JoystickButton aButtonOperator = new JoystickButton(operateController, Constants.A_BUTTON);
    final JoystickButton bButtonOperator = new JoystickButton(operateController, Constants.B_BUTTON);
    final JoystickButton yButtonOperator = new JoystickButton(operateController, Constants.Y_BUTTON);
    final JoystickButton lbButtonOperator = new JoystickButton(operateController, Constants.LB_BUTTON);
    // Commands
    aButtonOperator.whileHeld(new shooting(shooter));
    bButtonOperator.whileHeld(new activateIntake(intake, 0));
    yButtonOperator.whileHeld(new armStartup(colorwheelspinner));
    if(lbButtonOperator.get() && bButtonOperator.get()){
      lbButtonOperator.whileHeld(new activateIntake(intake, 1));
      bButtonOperator.whileHeld(new activateIntake(intake, 1));
    }
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    SendableChooser<Command> chooser = new SendableChooser<>();
    chooser.setDefaultOption("Test Auto", new autoMove(drivetrain));
    SmartDashboard.putData("Auto Mode", chooser);
    return chooser.getSelected();
}
}