/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;

// imports for motors 
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

// import for Motor Nums
import frc.robot.Constants;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
// import for tank drive
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  /**
   * Creates a new DriveTrain.
   */
  private CANSparkMax sparkLeftMaster, sparkLeftSlave1, sparkLeftSlave2, sparkRightMaster, sparkRightSlave1,
      sparkRightSlave2;
  private CANEncoder encoderLeftMaster, encoderLeftSlave1, encoderLeftSlave2, encoderRightMaster, encoderRightSlave1,
      encoderRightSlave2;
  private DifferentialDrive diffDrive;
  private SpeedControllerGroup leftDrive, rightDrive;

  public DriveTrain() {
    // controllers being contructered
    sparkLeftMaster = new CANSparkMax(Constants.LEFT_MASTER, MotorType.kBrushless);
    sparkLeftSlave1 = new CANSparkMax(Constants.LEFT_SLAVE_1, MotorType.kBrushless);
    sparkLeftSlave2 = new CANSparkMax(Constants.LEFT_SLAVE_2, MotorType.kBrushless);

    sparkRightMaster = new CANSparkMax(Constants.RIGHT_MASTER, MotorType.kBrushless);
    sparkRightSlave1 = new CANSparkMax(Constants.RIGHT_SLAVE_1, MotorType.kBrushless);
    sparkRightSlave2 = new CANSparkMax(Constants.RIGHT_SLAVE_2, MotorType.kBrushless);
    /*
     * encoders have to be contructed seperately in order to afford the stuttering
     * problem that occured in the Pre-Season of 2020. See documentation in the log
     * for more details regarding the encoder problem.
     * 
     * 
     */

    encoderLeftMaster = sparkLeftMaster.getEncoder();
    encoderLeftSlave1 = sparkLeftSlave1.getEncoder();
    encoderLeftSlave2 = sparkLeftSlave2.getEncoder();

    encoderRightMaster = sparkRightMaster.getEncoder();
    encoderRightSlave1 = sparkRightSlave1.getEncoder();
    encoderRightSlave2 = sparkRightSlave2.getEncoder();

    sparkLeftMaster.setInverted(false);
    sparkLeftSlave1.setInverted(false);
    sparkLeftSlave2.setInverted(false);

    sparkRightMaster.setInverted(true);
    sparkRightSlave1.setInverted(true);
    sparkRightSlave2.setInverted(true);

    sparkLeftSlave1.follow(sparkLeftMaster);
    sparkLeftSlave2.follow(sparkLeftMaster);

    sparkRightSlave1.follow(sparkRightMaster);
    sparkRightSlave2.follow(sparkRightMaster);

    // leftDrive = new SpeedControllerGroup(sparkLeftMaster, sparkLeftSlave1,
    // sparkLeftSlave2);
    // rightDrive = new SpeedControllerGroup(sparkRightMaster, sparkRightSlave1,
    // sparkRightSlave2);

    // diffDrive = new DifferentialDrive(leftDrive, rightDrive);

  }

  public void regDrive(double speedL, double speedR) {
    sparkLeftMaster.set(speedL);
    sparkRightMaster.set(speedR);
    // diffDrive.tankDrive(speedL, speedR);
  }

  public double getWheelPosFL() {
    return encoderLeftMaster.getPosition();
  }

  public double getWheelPosFR() {
    return encoderLeftSlave1.getPosition();
  }

  public double getWheelPosBL() {
    return encoderLeftSlave2.getPosition();
  }

  @Override
  public void periodic() {
    // setDefaultCommand(new Drive(getXboxXSpeed(), getXboxYSpeed()));
  }

}