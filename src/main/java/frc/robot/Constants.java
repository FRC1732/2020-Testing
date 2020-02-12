/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {

    // PROTOBOT
    public static int JOYSTICK_LEFT = 0;
    public static int JOYSTICK_RIGHT = 1;

    public static int JOYSTICK_SPINFORWARD = 1;
    public static int JOYSTICK_SPINBACKWARD = 2;
    
    public static int JOYSTICK_DECR_SHOOTER = 4;
    public static int JOYSTICK_SET_SHOOTER_50 = 3;
    public static int JOYSTICK_INCR_SHOOTER = 5;

    public static int JOYSTICK_SET_SHOOTER_0 = 1;
    // public static int JOYSTICK_SET_SHOOTER_0 = 6;
    public static int JOYSTICK_SET_SHOOTER_25 = 7;
    public static int JOYSTICK_SET_SHOOTER_75 = 10;
    public static int JOYSTICK_SET_SHOOTER_100 = 11;

    public static int LEFT_MASTER = 1;
    public static int LEFT_SLAVE_1 = 2;
    public static int LEFT_SLAVE_2 = 3;
    public static int RIGHT_MASTER = 4;
    public static int RIGHT_SLAVE_1 = 5;
    public static int RIGHT_SLAVE_2 = 6;

    // Climber mapping
    public static final int CLIMBER_RIGHT_ID = 10;
    public static final int CLIMBER_LEFT_ID = 35;
    public static final int CLIMBER_DRIVE_ID = 17;
    public static final int CLIMBING_SOLENOID_ID = 1;

    // Drivetrain mapping
    public static final int DRIVETRAIN_LEFTMASTER_ID = 33;
    public static final int DRIVETRAIN_LEFT1_ID = 34;
    public static final int DRIVETRAIN_LEFT2_ID = 35;
    public static final int DRIVETRAIN_RIGHTMASTER_ID = 10;
    public static final int DRIVETRAIN_RIGHT1_ID = 11;
    public static final int DRIVETRAIN_RIGHT2_ID = 12;

    // Shooter mapping
    public static final int SHOOTER_SHOOTER_ID = 9;
    public static final int SHOOTER_CAN_ID_TALONSRX = 30;
    public static final int SHOOTER_CAN_ID_VICTORSPX = 28;
    public static final int SHOOTER_ADJUSTMENT_SOLENOID_ID = 5;
    public static final int SHOOTER_ROTATION_SOLENOID_ID = 6;

    // Indexer mapping
    public static final int INDEXER_CONVEYER_ID = 15;
    public static final int INDEXER_CELLGATE_ID = 3;

    // Intake mapping
    public static final int INTAKE_INTAKEMOTOR_ID = 1;
    public static final int INTAKE_INTAKESOLENOID_ID = 6;

    // ControlPanelManip mapping
    public static final int CONTROLPANELMANIP_MOTOR_ID = 14;
    public static final int CONTROLPANELMANIP_TRENCH_HARDSTOP_SOLENOID_ID = 4;

    // Vision mapping
    public static final int VISION_LIMELIGHT_ID = 31;
}