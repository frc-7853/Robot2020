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
    // Victor motor controllers
    public static final int RIGHT_FRONT_VICTORPORT = 0;
    public static final int RIGHT_BACK_VICTORPORT = 1;
	public static final int LEFT_FRONT_VICTORPORT = 2;
	public static final int LEFT_BACK_VICTORPORT = 3;
    // Maximum acceleration for motors
    public static final double maxDriveSpeed = 0.6;
    public static final double shooterMotorSpeed = 0.01;
    
    // Joystick axis for movement
    public static final int DRIVER_CONTROLLER_PORT = 0;
	public static final int DRIVER_MOVE = 1;
	public static final int DRIVER_TURN = 4;
    // Victor Shooter motor controllers
    public static final int LEFT_SHOOTER_MOTOR = 4;
    public static final int RIGHT_SHOOTER_MOTOR = 5;
}