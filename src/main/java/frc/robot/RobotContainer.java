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
import edu.wpi.first.wpilibj2.command.button.POVButton;

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
  private final PneumaticsArm arm = new PneumaticsArm();
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

    
    // Operator buttons
    // POV, up is 0, right is 90, down 180, left is 270
    final POVButton dpadUpOperator = new POVButton(operateController, 0);
    final POVButton dpadDownOperator = new POVButton(operateController, 180);
    final JoystickButton aButtonOperator = new JoystickButton(operateController, Constants.A_BUTTON);
    final JoystickButton bButtonOperator = new JoystickButton(operateController, Constants.B_BUTTON);
    //final JoystickButton xButton = new JoystickButton(operateController, Constants.X_BUTTON);
    final JoystickButton ltButtonOperator = new JoystickButton(operateController, Constants.LT_BUTTON);
    final JoystickButton rtButtonOperator = new JoystickButton(operateController, Constants.RT_BUTTON);

    // Commands

    rtButtonOperator.whileHeld(new shooting(shooter));
    ltButtonOperator.whileHeld(new startArm(colorwheelspinner, true));
    dpadDownOperator.whenPressed(new raiseArm(arm, false));
    dpadUpOperator.whenPressed(new raiseArm(arm, true));
    //xButton.whileHeld(new armStartup(pneumaticsArm, 2));
    aButtonOperator.whileHeld(new activateIntake(intake, 0));
    bButtonOperator.whileHeld(new activateIntake(intake, 1));
    
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