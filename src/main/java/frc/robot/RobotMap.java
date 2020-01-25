/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
 /* public static int TALON_CAN_9 = 28;
  public static int TALON_CAN_11 = 11;
  public static int TALON_CAN_14 = 14;
  public static int TALON_CAN_15 = 15;
  public static int TALON_CAN_17 = 17;
  public static int TALON_CAN_16 = 16;
  */

  public static int TALON_CAN_30 = 30;
  public static int VICTOR_CAN_28 = 28;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  public static int JOYSTICK_0 = 0;
  public static int JOYSTICK_1 = 1;

  //Buttons
  public static int BTN_SPEED_1 = 1;
  public static int BTN_SPEED_2 = 2; 
  public static int BTN_SPEED_3 = 3; 
  public static int BTN_SPEED_4 = 4;
  public static int BTN_SPEED_5 = 5;
  public static int BTN_SPEED_6 = 6;
  public static int BTN_SPEED_7 = 7;
  public static int BTN_SPEED_8 = 8;
  public static int BTN_SPEED_9 = 9;
  public static int BTN_SPEED_10 = 10;
  public static int BTN_SPEED_11 = 11;
}