/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.EncoderType;
import com.revrobotics.jni.RevJNIWrapper;

import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.command.PrintCommand;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.util.MotorUtil;

/**
 * Add your docs here.
 */
public class DriveMotor_1 extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private final TalonSRX shooterMaster = MotorUtil.createTalon(RobotMap.TALON_CAN_9, false);
  private final VictorSPX shooterFollower = MotorUtil.createVictor(RobotMap.TALON_CAN_11, false);

  public DriveMotor_1(){
    shooterFollower.follow(shooterMaster);
    shooterMaster.set
  }

  public void forward() {
    shooterMaster.set(ControlMode.percentOutput, )
  }

  public void stop(){
    shooterMaster.set(ControlMode.PercentOutput, 0);
  }

  public void printVelocity(int velocity){
  }
  

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
