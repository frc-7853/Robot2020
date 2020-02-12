/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    // Top = Front, Bottom = Back
    // All tops are even all bottoms are odd
    // Victor Motor Controllers
    public static final int RIGHT_FRONT_PORT = 0;
    public static final int RIGHT_BACK_PORT = 1;
	public static final int LEFT_FRONT_PORT = 2;
    public static final int LEFT_BACK_PORT = 3;
    public static final int LEFT_SHOOTER_MOTOR = 4;
    public static final int RIGHT_SHOOTER_MOTOR = 5;
    public static final int COLOR_WHEEL_MOTOR_PORT = 6;
    public static final int INTAKE_WHEEL_MOTOR_PORT = 7; 
    public static final int PNEUMATIC_ARM_PORT = 0; // find the port for the pneumatics cylinder 
    
    
    //Pneumatic Arm Constants

    public static final int PNEUMATIC_ARM_FORWARD_CHANNEL = 0;
    public static final int PNEUMATIC_ARM_REVERSE_CHANNEL = 1;
    public static final int PNEUMATIC_ARM_SECOND_FOWARD_CHANNEL = 4;
    public static final int PNEUMATIC_ARM_SECOND_REVERSE_CHANNEL = 5;
    
    // Maximum acceleration for motors
    public static final double maxDriveSpeed = 0.6;

    public static final double defaultShooterSpeed = 0.2;
    public static final double increasedShooterSpeed = 0.5;

    public static final double colorWheelSpeed = 0.5;
    
    // Joystick axis for movement
    public static final int DRIVER_CONTROLLER_PORT = 0;
    public static final int OPERATOR_CONTROLLER_PORT = 1;
	public static final int DRIVER_MOVE = 1;
	public static final int DRIVER_TURN = 4;
    // Controller Buttons
    public static final int A_BUTTON = 1;
    public static final int B_BUTTON = 2;
    public static final int POVBUTTON_UP = 1;
    public static final int POVBUTTON_DOWN = 5; 
        //add button int for the D-pad
        //this might be wrong for the POV buttons
    } 