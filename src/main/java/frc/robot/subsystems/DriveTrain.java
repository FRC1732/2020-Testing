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

// import for tank drive
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  /**
   * Creates a new DriveTrain.
   */
  private CANSparkMax sparkLeftMaster, sparkLeftSlave1, sparkLeftSlave2;
  private CANEncoder encoderLeftMaster, encoderLeftSlave1, encoderLeftSlave2;

  public DriveTrain() {
    // controllers being contructered
    sparkLeftMaster = new CANSparkMax(Constants.SPARKFL, MotorType.kBrushless);
    sparkLeftSlave1 = new CANSparkMax(Constants.SPARKBL, MotorType.kBrushless);
    sparkLeftSlave2 = new CANSparkMax(Constants.SPARKBR, MotorType.kBrushless);
    /*
     * encoders have to be contructed seperately in order to afford the stuttering
     * problem that occured in the Pre-Season of 2020. See documentation in the log
     * for more details regarding the encoder problem.
     * 
     * 
     */
    // leftdrive = new SpeedControllerGroup(sparkFL, sparkBL);
    // rightdrive = new SpeedControllerGroup(sparkFR, sparkBR);

    encoderLeftMaster = sparkLeftMaster.getEncoder();
    encoderLeftSlave1 = sparkLeftSlave1.getEncoder();
    encoderLeftSlave2 = sparkLeftSlave2.getEncoder();

    sparkLeftSlave1.follow(sparkLeftMaster);
    sparkLeftSlave2.follow(sparkLeftMaster);

  }

  public void regDrive(double speedL, double speedR)
  { 
    sparkLeftMaster.set(speedL);
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