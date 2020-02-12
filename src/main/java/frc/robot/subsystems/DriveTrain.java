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
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  /**
   * Creates a new DriveTrain.
   */
  private CANSparkMax sparkLeftMaster, sparkLeftSlave1, sparkLeftSlave2, sparkRightMaster, sparkRightSlave1,
      sparkRightSlave2;
  private CANEncoder encoderLeftMaster, encoderLeftSlave1, encoderLeftSlave2, encoderRightMaster, encoderRightSlave1,
      encoderRightSlave2;

  public Drivetrain() {
    initializeMotorControllers();
  }

  private void initializeMotorControllers() {
    sparkLeftMaster = new CANSparkMax(Constants.DRIVETRAIN_LEFTMASTER_ID, MotorType.kBrushless);
    sparkLeftSlave1 = new CANSparkMax(Constants.DRIVETRAIN_LEFT1_ID, MotorType.kBrushless);
    sparkLeftSlave2 = new CANSparkMax(Constants.DRIVETRAIN_LEFT2_ID, MotorType.kBrushless);

    sparkRightMaster = new CANSparkMax(Constants.DRIVETRAIN_RIGHTMASTER_ID, MotorType.kBrushless);
    sparkRightSlave1 = new CANSparkMax(Constants.DRIVETRAIN_RIGHT1_ID, MotorType.kBrushless);
    sparkRightSlave2 = new CANSparkMax(Constants.DRIVETRAIN_RIGHT2_ID, MotorType.kBrushless);

    /*
     * encoders have to be contructed seperately in order to afford the stuttering
     * problem that occured in the Pre-Season of 2020. See documentation in the log
     * for more details regarding the encoder problem.
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

    sparkLeftMaster.setIdleMode(IdleMode.kCoast);
    sparkRightMaster.setIdleMode(IdleMode.kCoast);
    sparkLeftSlave1.setIdleMode(IdleMode.kCoast);
    sparkLeftSlave2.setIdleMode(IdleMode.kCoast);
    sparkRightSlave1.setIdleMode(IdleMode.kCoast);
    sparkRightSlave2.setIdleMode(IdleMode.kCoast);

    sparkLeftMaster.setOpenLoopRampRate(0);
    sparkLeftSlave1.setOpenLoopRampRate(0);
    sparkLeftSlave2.setOpenLoopRampRate(0);

    sparkRightMaster.setOpenLoopRampRate(0);
    sparkRightSlave1.setOpenLoopRampRate(0);
    sparkRightSlave2.setOpenLoopRampRate(0);

    sparkLeftMaster.setClosedLoopRampRate(0);
    sparkLeftSlave1.setClosedLoopRampRate(0);
    sparkLeftSlave2.setClosedLoopRampRate(0);

    sparkRightMaster.setClosedLoopRampRate(0);
    sparkRightSlave1.setClosedLoopRampRate(0);
    sparkRightSlave2.setClosedLoopRampRate(0);
  }

  public void regDrive(double speedL, double speedR) {
    sparkLeftMaster.set(speedL);
    sparkRightMaster.set(speedR);
  }

  public double getLeftMasterPos() {
    return encoderLeftMaster.getPosition();
  }

  public double getLeftSlave1Pos() {
    return encoderLeftSlave1.getPosition();
  }

  public double getLeftSlave2Pos() {
    return encoderLeftSlave2.getPosition();
  }

  public double getRightMasterPos() {
    return encoderRightMaster.getPosition();
  }

  public double getRightSlave1Pos() {
    return encoderRightSlave1.getPosition();
  }

  public double getRightSlave2Pos() {
    return encoderRightSlave2.getPosition();
  }

  @Override
  public void periodic() {
    // setDefaultCommand(new Drive(getXboxXSpeed(), getXboxYSpeed()));
  }

}